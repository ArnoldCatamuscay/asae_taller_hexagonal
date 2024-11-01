package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.Asignatura;
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

		Curso objCurso = this.objGestionarCursoGatewayIntPort.findById(objFranjaHoraria.getObjCurso().getId());
		CursoEntity objCursoEntity = this.franjaHorariaModelMapper.map(objCurso, CursoEntity.class);
		EspacioFisico objEspacioFisico = this.objGestionarEspacioFisicoGatewayIntPort.findById(objFranjaHoraria.getObjEspacioFisico().getId());
		EspacioFisicoEntity objEspacioFisicoEntity = this.franjaHorariaModelMapper.map(objEspacioFisico,EspacioFisicoEntity.class);

		objFranjaHorariaEntity.setObjCurso(objCursoEntity);
		objFranjaHorariaEntity.setObjEspacioFisico(objEspacioFisicoEntity);

		FranjaHorariaEntity objFranjaHorariaEntityRegistrado = this.objFranjaHorariaRepository.save(objFranjaHorariaEntity);
		FranjaHoraria objFranjaHorariaRespuesta = this.franjaHorariaModelMapper.map(objFranjaHorariaEntityRegistrado,FranjaHoraria.class);

		return objFranjaHorariaRespuesta;
	}

	@Override
	public List<FranjaHoraria> listarPorDocente(Integer idDocente) {
		List<FranjaHorariaEntity> franjasHorariasEntity = this.objFranjaHorariaRepository.findByDocenteId(idDocente);
		
		List<FranjaHoraria> franjasHorarias = new ArrayList<>();
		for(FranjaHorariaEntity franjaHorariaEntity : franjasHorariasEntity) {
			FranjaHoraria franjaHoraria = new FranjaHoraria();
			franjaHoraria.setId(franjaHorariaEntity.getId());
			franjaHoraria.setDia(franjaHorariaEntity.getDia());
			franjaHoraria.setHoraInicio(franjaHorariaEntity.getHoraInicio());
			franjaHoraria.setHoraFin(franjaHorariaEntity.getHoraFin());

			Asignatura asignatura = new Asignatura();
			asignatura.setId(franjaHorariaEntity.getObjCurso().getObjAsignatura().getId());
			asignatura.setNombre(franjaHorariaEntity.getObjCurso().getObjAsignatura().getNombre());
			asignatura.setCodigo(franjaHorariaEntity.getObjCurso().getObjAsignatura().getCodigo());
			
			Curso curso = new Curso();
			curso.setId(franjaHorariaEntity.getObjCurso().getId());
			curso.setNombre(franjaHorariaEntity.getObjCurso().getNombre());
			curso.setObjAsignatura(asignatura);
			
			EspacioFisico espacioFisico = new EspacioFisico();
			espacioFisico.setId(franjaHorariaEntity.getObjEspacioFisico().getId());
			espacioFisico.setNombre(franjaHorariaEntity.getObjEspacioFisico().getNombre());
			espacioFisico.setCapacidad(franjaHorariaEntity.getObjEspacioFisico().getCapacidad());
			
			franjaHoraria.setObjCurso(curso);
			franjaHoraria.setObjEspacioFisico(espacioFisico);
			franjasHorarias.add(franjaHoraria);
		}
		
		return franjasHorarias;
	}

	@Override
	public Boolean espacioFisicoOcupado(FranjaHoraria objFranjaHoraria) {
		Integer idEspacioFisico = objFranjaHoraria.getObjEspacioFisico().getId();
	
		if(this.objGestionarEspacioFisicoGatewayIntPort.isEspacioFisicoOccupied(objFranjaHoraria.getDia(),
			objFranjaHoraria.getHoraInicio(),objFranjaHoraria.getHoraFin(), idEspacioFisico)) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean docenteOcupado(FranjaHoraria objFranjaHoraria) {
		Integer idCurso = objFranjaHoraria.getObjCurso().getId();
		Curso objCurso = this.objGestionarCursoGatewayIntPort.findById(idCurso);
		
		for (Docente objDocente : objCurso.getDocentes()) {
			if(objGestionarDocenteGatewayIntPort.isDocenteOccupied(objFranjaHoraria.getDia(),
				objFranjaHoraria.getHoraInicio(),objFranjaHoraria.getHoraFin(),objDocente.getIdPersona())){
				return true;
			}
		}
		return false;
	}

}
