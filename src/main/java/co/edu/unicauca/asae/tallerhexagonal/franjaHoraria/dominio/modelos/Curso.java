package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos;

import java.util.HashSet;
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

    private Asignatura objAsignatura;
    
    private Set<Docente> docentes = new HashSet<>();

    // Constructor para el mapeo en FranjaHorariaMapperInfraestructuraDominio
    public Curso(Integer id) {
        this.id = id;
    }

}
