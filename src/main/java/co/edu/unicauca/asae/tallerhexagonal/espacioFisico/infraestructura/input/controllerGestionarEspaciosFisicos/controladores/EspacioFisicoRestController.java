package co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.controladores;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.input.controllerGestionarEspaciosFisicos.mappers.EspacioFisicoMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/espacios-fisicos")
@RequiredArgsConstructor
public class EspacioFisicoRestController {
	private final GestionarEspacioFisicoCUIntPort objGestionarEspacioFisicoCUInt;
	private final EspacioFisicoMapperInfraestructuraDominio objMapeador;

	@GetMapping("/")
	public String listar() {
		// TODO implementar
		return "Hola mundo";
	}
}
