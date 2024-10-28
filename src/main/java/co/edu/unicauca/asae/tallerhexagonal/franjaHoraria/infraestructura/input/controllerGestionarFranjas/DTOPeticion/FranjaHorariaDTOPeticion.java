package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaDTOPeticion {

    private String dia;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private Integer idCurso;

    private Integer idEspacioFisico;
}
