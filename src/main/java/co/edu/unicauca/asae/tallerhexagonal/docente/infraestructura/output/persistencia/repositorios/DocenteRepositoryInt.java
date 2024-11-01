package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.repositorios;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepositoryInt extends CrudRepository<DocenteEntity, Integer> {
    @Query(value = """
            SELECT COUNT(*) 
            FROM FranjasHorarias fh
            JOIN Cursos c ON fh.idCurso = c.id
            JOIN curso_docente cd ON c.id = cd.idCurso
            WHERE cd.idDocente = :idDocente
              AND fh.dia = :dia
              AND fh.horaInicio < :horaFin
              AND fh.horaFin > :horaInicio
            """, nativeQuery = true)
    int isDocenteOcupado(@Param("dia") String dia,
                             @Param("horaInicio") LocalTime horaInicio,
                             @Param("horaFin") LocalTime horaFin,
                             @Param("idDocente") int idDocente);

        boolean existsByCorreo(String correo);
}
