package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {
    private Integer id;
    private String nombre;
    private String codigo;
    private Set<Curso> cursos = new HashSet<>();
}
