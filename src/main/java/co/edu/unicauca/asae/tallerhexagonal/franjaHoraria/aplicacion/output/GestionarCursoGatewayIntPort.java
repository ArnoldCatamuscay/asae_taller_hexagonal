package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.Curso;

public interface GestionarCursoGatewayIntPort {
    Curso findById(Integer id);
}
