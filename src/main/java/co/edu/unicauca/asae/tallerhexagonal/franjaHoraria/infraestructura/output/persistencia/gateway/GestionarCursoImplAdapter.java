package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepositorioInt;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionarCursoImplAdapter implements GestionarCursoGatewayIntPort {
    private final CursoRepositorioInt objCursoRepository;
    private final ModelMapper cursoModelMapper;

    @Override
    public Curso findById(Integer id) {
        Optional<CursoEntity> objCursoEntity = null;
        objCursoEntity = objCursoRepository.findById(id);
        if (!objCursoEntity.isPresent()) {
            return null;
        }
        Curso objCurso = this.cursoModelMapper.map(objCursoEntity.get(), Curso.class);
        return objCurso;
    }
}
