package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EspacioFisicoMapper {
	@Bean
	public ModelMapper crearEspacioFisicoMapper() {
		return new ModelMapper();
	}
}
