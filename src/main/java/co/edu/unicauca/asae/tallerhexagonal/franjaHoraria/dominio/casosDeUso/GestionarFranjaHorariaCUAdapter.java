package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.casosDeUso;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.FranjaHorariaFormateadorResultadosIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaCUIntPort {

    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;
    private final FranjaHorariaFormateadorResultadosIntPort objEspacioFisicoFormateadorResultados;

    @Override
    public FranjaHoraria crearFranjaHoraria(FranjaHoraria objFranjaHoraria) {
        FranjaHoraria objFranjaHorariaCreado = null;
        objFranjaHorariaCreado = this.objGestionarFranjaHorariaGateway.crearFranjaHoraria(objFranjaHoraria);
        return objFranjaHorariaCreado;
    }
}
