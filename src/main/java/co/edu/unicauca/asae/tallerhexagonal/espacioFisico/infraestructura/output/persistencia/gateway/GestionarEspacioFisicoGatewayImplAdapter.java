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

	@Override
	public List<EspacioFisico> listar(String patron, Integer capacidad) {
		Iterable<EspacioFisicoEntity> listaEntidades = this.objEspacioFisicoRepository
			.findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqual(patron, capacidad);
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
		if(espacioFisicoBuscado.isEmpty()) {
			return null;
		}

		EspacioFisico espacioFisicoEncontrado = new EspacioFisico();
		espacioFisicoEncontrado.setId(espacioFisicoBuscado.get().getId());
		espacioFisicoEncontrado.setNombre(espacioFisicoBuscado.get().getNombre());
		espacioFisicoEncontrado.setCapacidad(espacioFisicoBuscado.get().getCapacidad());

		return espacioFisicoEncontrado;
	}

}
