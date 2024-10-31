package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output;

public interface EspacioFisicoFormateadorResultadosIntPort {

	void retornarRespuestaErrorEntidadNoExiste(String mensaje);

	void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
