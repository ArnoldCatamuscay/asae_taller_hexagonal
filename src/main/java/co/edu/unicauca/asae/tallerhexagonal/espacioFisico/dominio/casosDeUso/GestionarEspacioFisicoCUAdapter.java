package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.casosDeUso;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.EspacioFisicoFormateadorResultadosIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;

import java.util.List;

public class GestionarEspacioFisicoCUAdapter implements GestionarEspacioFisicoCUIntPort {

	private final GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway;
	private final EspacioFisicoFormateadorResultadosIntPort objEspacioFisicoFormateadorResultados;

	public GestionarEspacioFisicoCUAdapter(
		GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway,
		EspacioFisicoFormateadorResultadosIntPort objEspacioFisicoFormateadorResultados
	) {
		this.objGestionarEspacioFisicoGateway = objGestionarEspacioFisicoGateway;
		this.objEspacioFisicoFormateadorResultados = objEspacioFisicoFormateadorResultados;
	}

	@Override
	public List<EspacioFisico> listar() {
		// TODO Auto-generated method stub
		return List.of();
	}
}
