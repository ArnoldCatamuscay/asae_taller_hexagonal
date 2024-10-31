package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output;

public interface EspacioFisicoFormateadorResultadosIntPort {

	void retornarRespuestaErrorEntidadExiste(String mensaje);

	void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
