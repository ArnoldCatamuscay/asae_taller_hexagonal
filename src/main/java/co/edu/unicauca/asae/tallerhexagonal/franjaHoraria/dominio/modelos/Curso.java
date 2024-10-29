package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    private Integer id;

    private String nombre;

    // Constructor para el mapeo
    // en FranjaHorariaMapperInfraestructuraDominio
    public Curso(Integer id) {
        this.id = id;
    }

}
