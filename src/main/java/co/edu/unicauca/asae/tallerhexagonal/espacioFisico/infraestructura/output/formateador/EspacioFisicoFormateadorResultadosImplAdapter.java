package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.formateador;

import co.edu.unicauca.asae.tallerhexagonal.commons.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.tallerhexagonal.commons.controladorExcepciones.excepcionesPropias.ReglaNegocioException;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.EspacioFisicoFormateadorResultadosIntPort;
import org.springframework.stereotype.Service;

@Service
public class EspacioFisicoFormateadorResultadosImplAdapter implements EspacioFisicoFormateadorResultadosIntPort {

	@Override
	public void retornarRespuestaErrorEntidadNoExiste(String mensaje) {
		EntidadNoExisteException objException = new EntidadNoExisteException(mensaje);
		throw objException;
	}

	@Override
	public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
		ReglaNegocioException objException = new ReglaNegocioException(mensaje);
		throw objException;
	}
}
