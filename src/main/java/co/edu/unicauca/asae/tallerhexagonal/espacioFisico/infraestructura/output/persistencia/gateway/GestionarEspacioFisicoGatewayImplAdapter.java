package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepositorioInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionarEspacioFisicoGatewayImplAdapter implements GestionarEspacioFisicoGatewayIntPort {

	private final EspacioFisicoRepositorioInt objEspacioFisicoRepository;
	private final ModelMapper espacioFisicoModelMapper;

	public GestionarEspacioFisicoGatewayImplAdapter(
		EspacioFisicoRepositorioInt objEspacioFisicoRepository,
		ModelMapper espacioFisicoModelMapper
	) {
		this.objEspacioFisicoRepository = objEspacioFisicoRepository;
		this.espacioFisicoModelMapper = espacioFisicoModelMapper;
	}

	@Override
	public List<EspacioFisico> listar() {
		// TODO Auto-generated method stub
		return List.of();
	}
}
