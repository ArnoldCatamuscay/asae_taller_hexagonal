package co.edu.unicauca.asae.tallerhexagonal.commons.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppMapper {
	@Bean
	public ModelMapper crearMapper() {
		return new ModelMapper();
	}
}
