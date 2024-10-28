package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.FranjaHorariaFormateadorResultadosIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.casosDeUso.GestionarFranjaHorariaCUAdapter;

@Configuration
public class BeanConfigurationsFranjaHoraria {
    @Bean
    public GestionarFranjaHorariaCUAdapter crearGestionarFranjaHorariaCUInt(
            GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FranjaHorariaFormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        GestionarFranjaHorariaCUAdapter objGestionarFranjaHorariaCU = new GestionarFranjaHorariaCUAdapter(
                objGestionarFranjaHorariaGateway,
                objFranjaHorariaFormateadorResultados);
        return objGestionarFranjaHorariaCU;
    }
}
