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

    @Mapping(target = "curso", source = "idCurso", qualifiedByName = "idToCurso")
    @Mapping(target = "espacioFisico", source = "idEspacioFisico", qualifiedByName = "idToEspacioFisico")
    FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion peticion);

    FranjaHorariaDTORespuesta mappearDeFranjaHorariaARespuesta(FranjaHoraria franjaHoraria);

    // Métodos de conversión de IDs a objetos de dominio
    @Named("idToCurso")
    default Curso idToCurso(Integer idCurso) {
        return idCurso != null ? new Curso(idCurso) : null;
    }

    @Named("idToEspacioFisico")
    default EspacioFisico idToEspacioFisico(Integer idEspacioFisico) {
        return idEspacioFisico != null ? new EspacioFisico(idEspacioFisico) : null;
    }

    List<FranjaHorariaDTORespuesta> mappearDeFranjaHorariaARespuesta(List<FranjaHoraria> franjasHorarias);
}
