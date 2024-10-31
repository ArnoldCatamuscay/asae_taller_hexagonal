package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta;

import java.time.LocalTime;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.DTORespuesta.EspacioFisicoDTORespuesta;

public record FranjaHorariaDTORespuesta (

    Integer id,

    String dia,

    LocalTime horaInicio,

    LocalTime horaFin,

    CursoDTORespuesta curso,

    EspacioFisicoDTORespuesta espacioFisico
) {}
