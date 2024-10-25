package co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Administrativo extends Persona {
    private String rol;

    public Administrativo(int idPersona, String nombre, String apellido, String correo, String rol) {
        super(idPersona, nombre, apellido, correo);
        this.rol = rol;
    }
}
