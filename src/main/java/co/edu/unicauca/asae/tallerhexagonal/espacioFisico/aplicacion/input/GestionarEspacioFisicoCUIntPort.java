package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.input;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;

import java.time.LocalTime;
import java.util.List;

public interface GestionarEspacioFisicoCUIntPort {

	List<EspacioFisico> listar();

	Boolean isEspacioFisicoOccupied(String dia, LocalTime horaInicio, LocalTime horaFin, Integer id);

}
