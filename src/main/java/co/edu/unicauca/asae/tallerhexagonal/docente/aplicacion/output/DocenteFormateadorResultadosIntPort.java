package co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.output;

public interface DocenteFormateadorResultadosIntPort {
    void retornarRespuestaErrorEntidadExiste(String mensaje);

    void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
