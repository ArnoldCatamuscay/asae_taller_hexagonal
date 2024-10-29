package co.edu.unicauca.asae.tallerhexagonal.commons.configuracion;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.EspacioFisicoFormateadorResultadosIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.casosDeUso.GestionarEspacioFisicoCUAdapter;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.FranjaHorariaFormateadorResultadosIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.casosDeUso.GestionarFranjaHorariaCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

	//TODO: Crear Bean para el CU de Docentes

	@Bean
	public GestionarEspacioFisicoCUAdapter crearGestionarEspacioFisicoCUInt(
		GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway,
		EspacioFisicoFormateadorResultadosIntPort objEspacioFisicoFormateadorResultados
	) {
		GestionarEspacioFisicoCUAdapter objGestionarEspacioFisicoCU = new GestionarEspacioFisicoCUAdapter(
			objGestionarEspacioFisicoGateway,
			objEspacioFisicoFormateadorResultados
		);
		return objGestionarEspacioFisicoCU;
	}

	@Bean
	public GestionarFranjaHorariaCUAdapter crearGestionarFranjaHorariaCUInt(
		GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
		FranjaHorariaFormateadorResultadosIntPort objFranjaHorariaFormateadorResultados
	) {
		GestionarFranjaHorariaCUAdapter objGestionarFranjaHorariaCU = new GestionarFranjaHorariaCUAdapter(
			objGestionarFranjaHorariaGateway,
			objFranjaHorariaFormateadorResultados
		);
		return objGestionarFranjaHorariaCU;
	}

}
