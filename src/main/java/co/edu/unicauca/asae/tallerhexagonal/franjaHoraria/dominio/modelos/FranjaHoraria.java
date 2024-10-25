package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHoraria {
    private Integer id;

    private String dia;

    private LocalTime horaInicio;

    private LocalTime horaFin;
}
