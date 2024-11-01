package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.input.controllerGestionarFranjas.mappers.FranjaHorariaMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/franjas-horarias")
@Validated
@RequiredArgsConstructor
public class FranjaHorariaRestController {
    private final GestionarFranjaHorariaCUIntPort objGestionarFranjaHorariaCUInt;
    private final FranjaHorariaMapperInfraestructuraDominio objMapeador;

    @PostMapping("/")
    public ResponseEntity<FranjaHorariaDTORespuesta> crearFranjaHoraria(@RequestBody @Valid FranjaHorariaDTOPeticion objFranjaHoraria) {
        FranjaHoraria objFranjaHorariaCrear = objMapeador.mappearDePeticionAFranjaHoraria(objFranjaHoraria);
        FranjaHoraria objFranjaHorariaCreado = objGestionarFranjaHorariaCUInt.crear(objFranjaHorariaCrear);
        ResponseEntity<FranjaHorariaDTORespuesta> objRespuesta = new ResponseEntity<FranjaHorariaDTORespuesta>(
                objMapeador.mappearDeFranjaHorariaARespuesta(objFranjaHorariaCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/listarPorDocente/{id}")
    public ResponseEntity<List<FranjaHorariaDTORespuesta>> listarPorDocente(@Min(value = 0, message = "{filtrar.docente.id}") @PathVariable Integer id) {
        List<FranjaHoraria> franjasHorarias = objGestionarFranjaHorariaCUInt.listarPorDocente(id);
        ResponseEntity<List<FranjaHorariaDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaHorariaDTORespuesta>>(
            objMapeador.mappearDeFranjasHorariasARespuesta(franjasHorarias),
                HttpStatus.OK);
        return objRespuesta;
    }
    
}
