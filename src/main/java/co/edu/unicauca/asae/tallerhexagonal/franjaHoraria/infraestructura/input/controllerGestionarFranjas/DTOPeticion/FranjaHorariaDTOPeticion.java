package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
public record FranjaHorariaDTOPeticion (

    @NotNull(message = "{franjaHoraria.dia.null}")
    @Size(min = 5, max = 20, message = "{franjaHoraria.dia.size}")
    String dia,

    @NotNull(message = "{franjaHoraria.horaInicio.null}")
    LocalTime horaInicio,

    @NotNull(message = "{franjaHoraria.horaFin.null}")
    LocalTime horaFin,

    @NotNull(message = "{franjaHoraria.idCurso.null}")
    @Positive(message = "{franjaHoraria.idCurso.positive}")
    Integer idCurso,

    @NotNull(message = "{franjaHoraria.idEspacioFisico.null}")
    @Positive(message = "{franjaHoraria.idEspacioFisico.positive}")
    Integer idEspacioFisico
) {}
