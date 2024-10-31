package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    Docente mappearDePeticionADocente(DocenteDTOPeticion peticion);
    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente);
}
