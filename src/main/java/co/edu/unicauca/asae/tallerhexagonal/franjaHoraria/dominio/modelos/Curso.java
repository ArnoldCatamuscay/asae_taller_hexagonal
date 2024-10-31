package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos;

import java.util.Set;

import co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos.Docente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    private Integer id;

    private String nombre;

    private Set<Docente> docentes;

    // private Asignatura objAsignatura;

    // Constructor para el mapeo en FranjaHorariaMapperInfraestructuraDominio
    public Curso(Integer id) {
        this.id = id;
    }

}
