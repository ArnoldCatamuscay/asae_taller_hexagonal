package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.mappers;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.DTORespuesta.EspacioFisicoDTORespuesta;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EspacioFisicoMapperInfraestructuraDominio {
	// TODO: Implementar los métodos de mapeo

	List<EspacioFisicoDTORespuesta> mappearDeEspaciosFisicosARespuesta(List<EspacioFisico> espacioFisicos);
}
