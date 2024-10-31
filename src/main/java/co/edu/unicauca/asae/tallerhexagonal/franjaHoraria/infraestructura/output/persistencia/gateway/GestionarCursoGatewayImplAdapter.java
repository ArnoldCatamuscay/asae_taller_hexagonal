package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;

@Service
public class GestionarCursoGatewayImplAdapter implements GestionarCursoGatewayIntPort {
    private final CursoRepositoryInt objCursoRepository;
    private final ModelMapper cursoModelMapper;

    public GestionarCursoGatewayImplAdapter(CursoRepositoryInt objCursoRepository, ModelMapper cursoModelMapper) {
        this.objCursoRepository = objCursoRepository;
        this.cursoModelMapper = cursoModelMapper;
    }

    @Override
    public Curso findById(Integer id) {
        Optional<CursoEntity> objCursoEntity = objCursoRepository.findById(id);
        
        Curso objCurso = this.cursoModelMapper.map(objCursoEntity.get(), Curso.class);
        return objCurso;
    }
}
