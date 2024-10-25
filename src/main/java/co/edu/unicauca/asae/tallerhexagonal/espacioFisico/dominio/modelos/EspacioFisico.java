package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisico {
    private Integer id;
    private String nombre;
    private Integer capacidad;
}
