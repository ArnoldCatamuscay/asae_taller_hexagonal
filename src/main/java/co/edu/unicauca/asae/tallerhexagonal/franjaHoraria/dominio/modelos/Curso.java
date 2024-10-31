package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos;

import java.util.Set;

import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    private Integer id;

    private String nombre;

    private Set<DocenteEntity> docentes;

    // Constructor para el mapeo
    // en FranjaHorariaMapperInfraestructuraDominio
    public Curso(Integer id) {
        this.id = id;
    }

}
