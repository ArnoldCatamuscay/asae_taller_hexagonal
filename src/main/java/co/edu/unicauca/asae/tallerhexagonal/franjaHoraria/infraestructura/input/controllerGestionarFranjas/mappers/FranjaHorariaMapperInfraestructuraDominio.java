package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaDTORespuesta;

@Mapper(componentModel = "spring")
public interface FranjaHorariaMapperInfraestructuraDominio {

    @Mapping(target = "objCurso", source = "idCurso", qualifiedByName = "idToCurso")
    @Mapping(target = "objEspacioFisico", source = "idEspacioFisico", qualifiedByName = "idToEspacioFisico")
    FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion peticion);

    // Métodos de conversión de IDs a objetos de dominio
    @Named("idToCurso")
    default Curso idToCurso(Integer idCurso) {
        return idCurso != null ? new Curso(idCurso) : null;
    }

    @Named("idToEspacioFisico")
    default EspacioFisico idToEspacioFisico(Integer idEspacioFisico) {
        return idEspacioFisico != null ? new EspacioFisico(idEspacioFisico) : null;
    }

    FranjaHorariaDTORespuesta mappearDeFranjaHorariaARespuesta(FranjaHoraria franjaHoraria);

    List<FranjaHorariaDTORespuesta> mappearDeFranjasHorariasARespuesta(List<FranjaHoraria> franjasHorarias);
}
