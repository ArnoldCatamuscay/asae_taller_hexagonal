package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

public interface FranjaHorariaRepositoryInt extends CrudRepository<FranjaHorariaEntity, Integer> {
   @Query(value = """
            SELECT fh.* 
            FROM FranjasHorarias fh
            JOIN Cursos c ON fh.idCurso = c.id
            JOIN curso_docente cd ON c.id = cd.idCurso
            WHERE cd.idDocente = :idDocente
            """, nativeQuery = true)
    List<FranjaHorariaEntity> findByDocenteId(@Param("idDocente") int idDocente);
}
