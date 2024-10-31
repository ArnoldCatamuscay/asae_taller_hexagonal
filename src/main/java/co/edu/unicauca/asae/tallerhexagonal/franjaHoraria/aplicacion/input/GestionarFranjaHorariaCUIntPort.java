package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.input;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;
import java.util.List;

public interface GestionarFranjaHorariaCUIntPort {

    FranjaHoraria crear(FranjaHoraria objFranjaHoraria);

    List<FranjaHoraria> listarPorDocente(Integer idDocente);
}
