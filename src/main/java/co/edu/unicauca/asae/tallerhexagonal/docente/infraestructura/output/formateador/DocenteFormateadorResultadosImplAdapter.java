package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.commons.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.tallerhexagonal.commons.controladorExcepciones.excepcionesPropias.ReglaNegocioException;
import co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.output.DocenteFormateadorResultadosIntPort;

@Service
public class DocenteFormateadorResultadosImplAdapter implements DocenteFormateadorResultadosIntPort {

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
    
}
