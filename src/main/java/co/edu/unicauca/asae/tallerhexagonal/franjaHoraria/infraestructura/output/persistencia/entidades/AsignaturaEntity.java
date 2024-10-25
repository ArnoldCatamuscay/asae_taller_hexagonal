package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Asignaturas")
public class AsignaturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 255, nullable = false)
    private String nombre;
    @Column(length = 50)
    private String codigo;

    // * Relación */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objAsignatura")
    private List<CursoEntity> cursos;

    public AsignaturaEntity() {
        this.cursos = new ArrayList<CursoEntity>();
    }
}
