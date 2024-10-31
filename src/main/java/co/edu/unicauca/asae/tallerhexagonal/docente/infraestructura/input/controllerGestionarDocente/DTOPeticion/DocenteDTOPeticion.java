package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DocenteDTOPeticion(

    @NotNull(message = "{docente.nombre.null}")
    @Size(min = 3, max = 50, message = "{docente.nombre.size}")
    String nombre,
    @NotNull(message = "{docente.apellido.null}")
    @Size(min = 4, max = 50, message = "{docente.apellido.size}")
    String apellido,
    @NotNull(message = "{docente.correo.null}")
    @NotEmpty(message = "{docente.correo.empty}")
    @Email(message = "{docente.correo.invalid}")
    String correo,
    @Valid
    @NotNull(message = "{docente.oficina.null}")
    OficinaDTOPeticion oficina
) {}
