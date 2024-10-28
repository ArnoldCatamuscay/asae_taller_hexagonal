package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.FranjaHorariaFormateadorResultadosIntPort;

@Service
public class FranjaHorariaFormateadorResultadosImplAdapter implements FranjaHorariaFormateadorResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retornarRespuestaErrorEntidadExiste'");
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retornarRespuestaErrorReglaDeNegocio'");
    }

}
