package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.commons.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.tallerhexagonal.commons.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.tallerhexagonal.commons.controladorExcepciones.excepcionesPropias.ReglaNegocioException;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.FranjaHorariaFormateadorResultadosIntPort;

@Service
public class FranjaHorariaFormateadorResultadosImplAdapter implements FranjaHorariaFormateadorResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioException objException = new ReglaNegocioException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorEntidadNoExiste(String mensaje) {
        EntidadNoExisteException objException = new EntidadNoExisteException(mensaje);
        throw objException;

    }

}
