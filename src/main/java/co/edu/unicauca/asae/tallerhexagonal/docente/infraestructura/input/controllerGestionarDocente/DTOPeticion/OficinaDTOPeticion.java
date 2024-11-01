package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OficinaDTOPeticion(
    @NotNull(message = "{oficina.nombre.null}")
    @Size(min = 4, max = 20, message = "{oficina.nombre.size}")
    String nombre,
    @NotNull(message = "{oficina.ubicacion.null}")
    @Size(min = 4, max = 50, message = "{oficina.ubicacion.size}")
    String ubicacion
) {}
