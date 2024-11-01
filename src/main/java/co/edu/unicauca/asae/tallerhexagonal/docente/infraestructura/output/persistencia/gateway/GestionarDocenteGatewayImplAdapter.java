package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.gateway;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.entidades.OficinaEntity;
import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final DocenteRepositoryInt objDocenteRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocenteRepositoryInt objDocenteRepository, ModelMapper docenteModelMapper) {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docenteModelMapper;
    }

    @Override
    public Docente guardar(Docente objDocente) {
        OficinaEntity objOficinaEntity = this.docenteModelMapper.map(
            objDocente.getOficina(), 
            OficinaEntity.class
        );

        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(
            objDocente, 
            DocenteEntity.class
        );
        
        objDocenteEntity.setObjOficina(objOficinaEntity);
        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository
			.save(objDocenteEntity);
		Docente objDocenteRespuesta = this.docenteModelMapper.map(
			objDocenteEntityRegistrado,
			Docente.class
		);
        return objDocenteRespuesta;
    }

    @Override
    public Boolean isDocenteOccupied(String dia, LocalTime horaInicio, LocalTime horaFin, int idDocente) {
        int cont = this.objDocenteRepository.isDocenteOcupado(dia, horaInicio, horaFin, idDocente);
        return cont>0;
    }

    @Override
    public Boolean existePorCorreo(String correo) {
        return this.objDocenteRepository.existsByCorreo(correo);
    }

}
