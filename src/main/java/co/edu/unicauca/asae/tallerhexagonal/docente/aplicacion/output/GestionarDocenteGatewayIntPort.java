package co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.output;

import java.time.LocalTime;

import co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {
    Docente guardar(Docente objDocente);
    Boolean isDocenteOccupied(String dia, LocalTime horaInicio, LocalTime horaFin, int idDocente);
}
