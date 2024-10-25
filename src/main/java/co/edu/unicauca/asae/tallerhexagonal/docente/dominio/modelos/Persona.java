package co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private int idPersona;

    private String nombre;

    private String apellido;

    private String correo;
}
