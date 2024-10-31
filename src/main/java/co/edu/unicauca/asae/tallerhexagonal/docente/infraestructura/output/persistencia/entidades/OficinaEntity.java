package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Oficinas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OficinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOficina;
    @Column(nullable = false, length = 20)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String ubicacion;

    @OneToOne(mappedBy = "objOficina")
    private DocenteEntity objDocente;

}
