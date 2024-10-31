package co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.tallerhexagonal.docente.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.tallerhexagonal.docente.infraestructura.input.controllerGestionarDocente.mappers.DocenteMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/docentes")
@RequiredArgsConstructor
public class DocenteRestController {

    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final DocenteMapperInfraestructuraDominio objMapeador;

    @PostMapping("/")
    public ResponseEntity<DocenteDTORespuesta> postMethodName(@RequestBody @Valid DocenteDTOPeticion objDocente) {
        Docente objDocenteCrear = objMapeador.mappearDePeticionADocente(objDocente);
        Docente objDocenteCreado = objGestionarDocenteCUInt.crear(objDocenteCrear);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<>(
                objMapeador.mappearDeDocenteARespuesta(objDocenteCreado),
                org.springframework.http.HttpStatus.CREATED);
        return objRespuesta;
    }
    
}
