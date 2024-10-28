package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

public interface FranjaHorariaRepositorioInt extends CrudRepository<FranjaHorariaEntity, Integer> {

}
