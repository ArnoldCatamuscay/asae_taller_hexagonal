package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepositoryInt extends CrudRepository<DocenteEntity, Integer> {

}
