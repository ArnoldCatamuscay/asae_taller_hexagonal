package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisicoDTORespuesta {
    private String nombre;
    private Integer capacidad;
}
