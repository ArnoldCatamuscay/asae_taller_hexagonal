package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.controladores;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.DTORespuesta.EspacioFisicoDTORespuesta;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.mappers.EspacioFisicoMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/espacios-fisicos")
@RequiredArgsConstructor
public class EspacioFisicoRestController {
	private final GestionarEspacioFisicoCUIntPort objGestionarEspacioFisicoCUInt;
	private final EspacioFisicoMapperInfraestructuraDominio objMapeador;

	@GetMapping("/")
	public ResponseEntity<List<EspacioFisicoDTORespuesta>> listar(@RequestParam String patron, @RequestParam Integer capacidad) {
		ResponseEntity<List<EspacioFisicoDTORespuesta>> objRespuesta = new ResponseEntity<>(
			objMapeador.mappearDeEspaciosFisicosARespuesta(this.objGestionarEspacioFisicoCUInt.listar(patron, capacidad)),
			HttpStatus.OK);
		return objRespuesta;
	}

	@GetMapping("/isOccupied")
	public Boolean isEspacioFisicoOccupied(
		@RequestParam String dia,
		@RequestParam LocalTime horaInicio,
		@RequestParam LocalTime horaFin,
		@RequestParam Integer id
	) {
		return objGestionarEspacioFisicoCUInt.isEspacioFisicoOccupied(dia, horaInicio, horaFin, id);
	}

}
