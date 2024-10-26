package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import org.springframework.data.repository.CrudRepository;

public interface EspacioFisicoRepositorioInt extends CrudRepository<EspacioFisicoEntity, Integer> {
	// TODO: Implementar método para listar espacios físicos personalizado
}
