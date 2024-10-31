package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.DTORespuesta;

public record DocenteDTORespuesta(
    String nombre,
    String apellido,
    String correo,
    OficinaDTORespuesta oficina
) {}
