package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepositorioInt;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class GestionarEspacioFisicoGatewayImplAdapter implements GestionarEspacioFisicoGatewayIntPort {

	private final EspacioFisicoRepositorioInt objEspacioFisicoRepository;
	private final ModelMapper espacioFisicoModelMapper;

	public GestionarEspacioFisicoGatewayImplAdapter(
			EspacioFisicoRepositorioInt objEspacioFisicoRepository,
			ModelMapper espacioFisicoModelMapper) {
		this.objEspacioFisicoRepository = objEspacioFisicoRepository;
		this.espacioFisicoModelMapper = espacioFisicoModelMapper;
	}

	@Override
	public List<EspacioFisico> listar() {

		Iterable<EspacioFisicoEntity> lista = this.objEspacioFisicoRepository
				.findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqual("sa", 20);
		for (EspacioFisicoEntity espacioFisicoEntity : lista) {
			System.out.println("id: " + espacioFisicoEntity.getId());
			System.out.println("nombre: " + espacioFisicoEntity.getNombre());
			System.out.println("capacidad: " + espacioFisicoEntity.getCapacidad() + "\n");
		}
		List<EspacioFisico> listaObtenida = this.espacioFisicoModelMapper.map(lista,
				new TypeToken<List<EspacioFisico>>() {
				}.getType());

		return listaObtenida;
	}

	@Override
	public Boolean isEspacioFisicoOccupied(String dia, LocalTime horaInicio, LocalTime horaFin, Integer id) {
		Integer count = objEspacioFisicoRepository.isEspacioFisicoOccupied(dia, horaInicio, horaFin, id);
		return count > 0;
	}

}
