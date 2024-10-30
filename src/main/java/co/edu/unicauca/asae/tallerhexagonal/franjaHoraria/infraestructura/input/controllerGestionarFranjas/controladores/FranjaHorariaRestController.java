package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.mappers.FranjaHorariaMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/franjas-horarias")
@RequiredArgsConstructor
public class FranjaHorariaRestController {
    private final GestionarFranjaHorariaCUIntPort objGestionarFranjaHorariaCUInt;
    private final FranjaHorariaMapperInfraestructuraDominio objMapeador;

    @PostMapping("/")
    public ResponseEntity<FranjaHorariaDTORespuesta> crearFranjaHoraria(@RequestBody FranjaHorariaDTOPeticion objFranjaHoraria) {
        FranjaHoraria objFranjaHorariaCrear = objMapeador.mappearDePeticionAFranjaHoraria(objFranjaHoraria);
        FranjaHoraria objFranjaHorariaCreado = objGestionarFranjaHorariaCUInt.crear(objFranjaHorariaCrear);
        ResponseEntity<FranjaHorariaDTORespuesta> objRespuesta = new ResponseEntity<FranjaHorariaDTORespuesta>(
                objMapeador.mappearDeFranjaHorariaARespuesta(objFranjaHorariaCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }
}
