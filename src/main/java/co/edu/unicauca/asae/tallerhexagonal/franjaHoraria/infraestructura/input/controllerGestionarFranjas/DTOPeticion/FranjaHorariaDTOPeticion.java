package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record FranjaHorariaDTOPeticion (

    String dia,

    LocalTime horaInicio,

    LocalTime horaFin,

    Integer idCurso,

    Integer idEspacioFisico
) {}
