package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output;

public interface FranjaHorariaFormateadorResultadosIntPort {
    void retornarRespuestaErrorEntidadExiste(String mensaje);

    void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
