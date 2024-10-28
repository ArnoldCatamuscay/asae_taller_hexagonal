package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface EspacioFisicoRepositorioInt extends CrudRepository<EspacioFisicoEntity, Integer> {
	// TODO: Implementar método para listar espacios físicos personalizado}
	List<EspacioFisicoEntity> findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqual(String patron,
			Integer capacidad);

	@Query("""
			Select count(*) FROM FranjaHorariaEntity f
			JOIN f.objEspacioFisico e
			WHERE e.id = :id
			AND f.dia = :dia
			AND f.horaInicio < :horaFin
			AND	f.horaFin > :horaInicio
			""")
	Integer isEspacioFisicoOccupied(@Param("dia") String dia, @Param("horaInicio") LocalTime horaInicio,
			@Param("horaFin") LocalTime horaFin, @Param("id") Integer id);
}
