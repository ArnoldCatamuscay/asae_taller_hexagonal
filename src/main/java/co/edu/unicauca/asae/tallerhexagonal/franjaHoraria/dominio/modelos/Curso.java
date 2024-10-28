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

    public Curso(Integer id) {
        this.id = id;
    }

}
