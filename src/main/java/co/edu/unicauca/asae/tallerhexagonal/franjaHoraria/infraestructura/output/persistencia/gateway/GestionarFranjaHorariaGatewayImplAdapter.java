package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.commons.controladorExcepciones.excepcionesPropias.ReglaNegocioException;
import co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepositoryInt;

@Service
public class GestionarFranjaHorariaGatewayImplAdapter implements GestionarFranjaHorariaGatewayIntPort {

	private final FranjaHorariaRepositoryInt objFranjaHorariaRepository;
	private final ModelMapper franjaHorariaModelMapper;
	private final GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGatewayIntPort;
	private final GestionarCursoGatewayIntPort objGestionarCursoGatewayIntPort;
	private final GestionarDocenteGatewayIntPort objGestionarDocenteGatewayIntPort;

	public GestionarFranjaHorariaGatewayImplAdapter(
		FranjaHorariaRepositoryInt objFranjaHorariaRepository,
		ModelMapper franjaHorariaModelMapper,
		GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGatewayIntPort,
		GestionarCursoGatewayIntPort objGestionarCursoGatewayIntPort,
		GestionarDocenteGatewayIntPort objGestionarDocenteGatewayIntPort
	) {
		this.objFranjaHorariaRepository = objFranjaHorariaRepository;
		this.franjaHorariaModelMapper = franjaHorariaModelMapper;
		this.objGestionarEspacioFisicoGatewayIntPort = objGestionarEspacioFisicoGatewayIntPort;
		this.objGestionarCursoGatewayIntPort = objGestionarCursoGatewayIntPort;
		this.objGestionarDocenteGatewayIntPort = objGestionarDocenteGatewayIntPort;
	}

	@Override
	public FranjaHoraria guardar(FranjaHoraria objFranjaHoraria) {
		FranjaHorariaEntity objFranjaHorariaEntity = this.franjaHorariaModelMapper.map(
			objFranjaHoraria,
			FranjaHorariaEntity.class
		);

		Curso objCurso = this.objGestionarCursoGatewayIntPort.findById(objFranjaHoraria.getCurso().getId());
		CursoEntity objCursoEntity = this.franjaHorariaModelMapper.map(objCurso, CursoEntity.class);
		EspacioFisico objEspacioFisico = this.objGestionarEspacioFisicoGatewayIntPort
			.findById(objFranjaHoraria.getEspacioFisico().getId());
		EspacioFisicoEntity objEspacioFisicoEntity = this.franjaHorariaModelMapper.map(objEspacioFisico,
			EspacioFisicoEntity.class);

		objFranjaHorariaEntity.setObjCurso(objCursoEntity);
		objFranjaHorariaEntity.setObjEspacioFisico(objEspacioFisicoEntity);

		// Validar que el espacio físico no esté ocupado
		if(this.objGestionarEspacioFisicoGatewayIntPort.isEspacioFisicoOccupied(objFranjaHoraria.getDia(),
			objFranjaHoraria.getHoraInicio(),
			objFranjaHoraria.getHoraFin(),
			objEspacioFisicoEntity.getId())) {
			throw new ReglaNegocioException("El espacio físico ya está ocupado en ese horario");
		}
		
		// Validar que el docente no esté ocupado
		for (DocenteEntity objDocenteEntity : objCursoEntity.getDocentes()) {
			if(objGestionarDocenteGatewayIntPort.isDocenteOccupied(objFranjaHoraria.getDia(),
			objFranjaHoraria.getHoraInicio(),
			objFranjaHoraria.getHoraFin(),
			objDocenteEntity.getIdPersona())){
				throw new ReglaNegocioException("El docente ya tiene una franja horaria asignada en ese horario");
			}
		}

		FranjaHorariaEntity objFranjaHorariaEntityRegistrado = this.objFranjaHorariaRepository
			.save(objFranjaHorariaEntity);
		FranjaHoraria objFranjaHorariaRespuesta = this.franjaHorariaModelMapper.map(
			objFranjaHorariaEntityRegistrado,
			FranjaHoraria.class
		);

		return objFranjaHorariaRespuesta;
	}

	@Override
	public List<FranjaHoraria> listarPorDocente(Integer idDocente) {
		List<FranjaHorariaEntity> franjasHorariasEntity = this.objFranjaHorariaRepository
			.findByDocenteId(idDocente);
		List<FranjaHoraria> franjasHorarias = this.franjaHorariaModelMapper.map(
			franjasHorariasEntity,
			new TypeToken<List<FranjaHoraria>>() {
			}.getType()
		);
		return franjasHorarias;
	}

}
