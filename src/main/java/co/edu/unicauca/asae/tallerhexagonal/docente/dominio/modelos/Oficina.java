package co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oficina {
    private int idOficina;

    private String nombre;

    private String ubicacion;
}
