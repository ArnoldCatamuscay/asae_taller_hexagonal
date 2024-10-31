package co.edu.unicauca.asae.tallerhexagonal.docente.dominio.casosDeUso;

import co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.output.DocenteFormateadorResultadosIntPort;
import co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos.Docente;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {

    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final DocenteFormateadorResultadosIntPort objDocenteFormateadorResultados;

    @Override
    public Docente crear(Docente objDocente) {
        Docente objDocenteCreado = null;
        objDocenteCreado = this.objGestionarDocenteGateway.guardar(objDocente);
        return objDocenteCreado;
    }

}
