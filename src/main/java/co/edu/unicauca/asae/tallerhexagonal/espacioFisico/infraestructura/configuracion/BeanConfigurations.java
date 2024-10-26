package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.configuracion;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.EspacioFisicoFormateadorResultadosIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.casosDeUso.GestionarEspacioFisicoCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

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
}
