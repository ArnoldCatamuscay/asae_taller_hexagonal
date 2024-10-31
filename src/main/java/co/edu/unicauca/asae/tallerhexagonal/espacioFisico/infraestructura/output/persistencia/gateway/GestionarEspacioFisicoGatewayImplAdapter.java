package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class GestionarEspacioFisicoGatewayImplAdapter implements GestionarEspacioFisicoGatewayIntPort {

	private final EspacioFisicoRepositoryInt objEspacioFisicoRepository;
	private final ModelMapper espacioFisicoModelMapper;

	public GestionarEspacioFisicoGatewayImplAdapter(
		EspacioFisicoRepositoryInt objEspacioFisicoRepository,
		ModelMapper espacioFisicoModelMapper
	) {
		this.objEspacioFisicoRepository = objEspacioFisicoRepository;
		this.espacioFisicoModelMapper = espacioFisicoModelMapper;
	}

	// TODO: Agregar parámetros de búsqueda para nombre y capacidad
	@Override
	public List<EspacioFisico> listar() {
		Iterable<EspacioFisicoEntity> listaEntidades = this.objEspacioFisicoRepository
			.findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqual("sa", 20);
		List<EspacioFisico> listaObtenida = this.espacioFisicoModelMapper.map(
			listaEntidades,
			new TypeToken<List<EspacioFisico>>() {}.getType()
		);

		return listaObtenida;
	}

	@Override
	public Boolean isEspacioFisicoOccupied(String dia, LocalTime horaInicio, LocalTime horaFin, Integer id) {
		Integer count = objEspacioFisicoRepository.isEspacioFisicoOccupied(id, dia, horaInicio, horaFin);

		return count > 0;
	}

	@Override
	public EspacioFisico findById(Integer id) {
		Optional<EspacioFisicoEntity> espacioFisicoBuscado = objEspacioFisicoRepository.findById(id);
		// TODO: Usar excepcion EntidadNoExisteException
		if (espacioFisicoBuscado.isEmpty()) {
			return null;
		}
		EspacioFisico espacioFisicoEncontrado = this.espacioFisicoModelMapper.map(
			espacioFisicoBuscado.get(),
			EspacioFisico.class
		);

		return espacioFisicoEncontrado;
	}

}
