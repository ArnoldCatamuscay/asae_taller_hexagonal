package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.casosDeUso;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.EspacioFisicoFormateadorResultadosIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;

import java.time.LocalTime;
import java.util.List;

public class GestionarEspacioFisicoCUAdapter implements GestionarEspacioFisicoCUIntPort {

	private final GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway;
	private final EspacioFisicoFormateadorResultadosIntPort objEspacioFisicoFormateadorResultados;

	public GestionarEspacioFisicoCUAdapter(
			GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway,
			EspacioFisicoFormateadorResultadosIntPort objEspacioFisicoFormateadorResultados) {
		this.objGestionarEspacioFisicoGateway = objGestionarEspacioFisicoGateway;
		this.objEspacioFisicoFormateadorResultados = objEspacioFisicoFormateadorResultados;
	}

	@Override
	public List<EspacioFisico> listar(String patron, Integer capacidad) {
		List<EspacioFisico> listaObtenida = objGestionarEspacioFisicoGateway.listar(patron, capacidad);
		if (listaObtenida.isEmpty()) {
            objEspacioFisicoFormateadorResultados
                .retornarRespuestaErrorEntidadNoExiste("No se encontraron espacios físicos con los criterios especificados.");
        }
		return listaObtenida;
	}

	@Override
	public Boolean isEspacioFisicoOccupied(String dia, LocalTime horaInicio, LocalTime horaFin, Integer id) {
		
		return objGestionarEspacioFisicoGateway.isEspacioFisicoOccupied(dia, horaInicio, horaFin, id);
	}
}
