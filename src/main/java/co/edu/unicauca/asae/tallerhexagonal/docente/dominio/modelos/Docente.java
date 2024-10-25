package co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Docente extends Persona {
    private Oficina oficina;

    public Docente(int idPersona, String nombre, String apellido, String correo) {
        super(idPersona, nombre, apellido, correo);
    }
}
