package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.Asignatura;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;

@Service
public class GestionarCursoGatewayImplAdapter implements GestionarCursoGatewayIntPort {
    private final CursoRepositoryInt objCursoRepository;

    public GestionarCursoGatewayImplAdapter(CursoRepositoryInt objCursoRepository) {
        this.objCursoRepository = objCursoRepository;
    }

    @Override
    public Curso findById(Integer id) {
        Optional<CursoEntity> objCursoEntity = objCursoRepository.findById(id);
        if (objCursoEntity.isEmpty()) {
            return null;
        }

        Curso objCurso = new Curso();
        objCurso.setId(objCursoEntity.get().getId());
        objCurso.setNombre(objCursoEntity.get().getNombre());

        Asignatura objAsignatura = new Asignatura();
        objAsignatura.setId(objCursoEntity.get().getObjAsignatura().getId());
        objAsignatura.setNombre(objCursoEntity.get().getObjAsignatura().getNombre());
        objAsignatura.setCodigo(objCursoEntity.get().getObjAsignatura().getCodigo());
        objCurso.setObjAsignatura(objAsignatura);

        Set<Docente> docentes = new HashSet<>();
        objCursoEntity.get().getDocentes().forEach(docenteEntity -> {
            Docente objDocente = new Docente();
            objDocente.setIdPersona(docenteEntity.getIdPersona());
            objDocente.setNombre(docenteEntity.getNombre());
            objDocente.setCorreo(docenteEntity.getCorreo());
            docentes.add(objDocente);
        });
        objCurso.setDocentes(docentes);
        
        return objCurso;
    }
}
