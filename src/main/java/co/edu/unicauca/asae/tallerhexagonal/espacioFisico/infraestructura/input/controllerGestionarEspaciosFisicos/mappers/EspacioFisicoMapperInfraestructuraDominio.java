package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.mappers;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.DTORespuesta.EspacioFisicoDTORespuesta;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EspacioFisicoMapperInfraestructuraDominio {

	EspacioFisicoDTORespuesta mappearDeEspacioFisicoARespuesta(EspacioFisico espacioFisico);

	List<EspacioFisicoDTORespuesta> mappearDeEspaciosFisicosARespuesta(List<EspacioFisico> espacioFisicos);
}
