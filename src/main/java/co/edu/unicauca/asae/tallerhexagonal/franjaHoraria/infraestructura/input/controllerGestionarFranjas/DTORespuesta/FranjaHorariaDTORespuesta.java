package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta;

import java.time.LocalTime;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.DTORespuesta.EspacioFisicoDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaDTORespuesta {

    private Integer id;

    private String dia;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private CursoDTORespuesta curso;

    private EspacioFisicoDTORespuesta espacioFisico;
}
