package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisico {
    private Integer id;
    private String nombre;
    private Integer capacidad;

    // Constructor para el mapeo
    // en FranjaHorariaMapperInfraestructuraDominio
    public EspacioFisico(Integer id) {
        this.id = id;
    }
}
