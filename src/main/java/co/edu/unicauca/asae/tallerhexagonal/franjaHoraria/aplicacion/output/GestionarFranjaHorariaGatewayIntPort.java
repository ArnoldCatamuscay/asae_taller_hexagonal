package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;

import java.util.List;

public interface GestionarFranjaHorariaGatewayIntPort {

    Boolean docenteOcupado(FranjaHoraria objFranjaHoraria);

    Boolean espacioFisicoOcupado(FranjaHoraria objFranjaHoraria);

    FranjaHoraria guardar(FranjaHoraria objFranjaHoraria);

    List<FranjaHoraria> listarPorDocente(Integer idDocente);
}
