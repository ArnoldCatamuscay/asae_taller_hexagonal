package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.FranjaHorariaFormateadorResultadosIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaCUIntPort {

    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;
    private final FranjaHorariaFormateadorResultadosIntPort objFranjaHorariaFormateadorResultados;
    private final GestionarCursoGatewayIntPort objGestionarCursoGateway;
    private final GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway;

    @Override
    public FranjaHoraria crear(FranjaHoraria objFranjaHoraria) {
        FranjaHoraria objFranjaHorariaCreado = null;

        if(this.objGestionarCursoGateway.findById(objFranjaHoraria.getObjCurso().getId()) == null){
            this.objFranjaHorariaFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("Error, el curso no existe");
        }
        if(this.objGestionarEspacioFisicoGateway.findById(objFranjaHoraria.getObjEspacioFisico().getId()) == null){
            this.objFranjaHorariaFormateadorResultados
                .retornarRespuestaErrorEntidadNoExiste("Error, el espacio físico no existe");
        }
        if(this.objGestionarFranjaHorariaGateway.docenteOcupado(objFranjaHoraria)){
            this.objFranjaHorariaFormateadorResultados
                .retornarRespuestaErrorReglaDeNegocio("Error, el docente ya tiene una franja horaria asignada en ese horario");
        }
        if(this.objGestionarFranjaHorariaGateway.espacioFisicoOcupado(objFranjaHoraria)){
            this.objFranjaHorariaFormateadorResultados
                .retornarRespuestaErrorReglaDeNegocio("Error, el espacio físico ya está ocupado en ese horario");
        }
        
        objFranjaHorariaCreado = this.objGestionarFranjaHorariaGateway.guardar(objFranjaHoraria);
        return objFranjaHorariaCreado;
    }

    @Override
    public List<FranjaHoraria> listarPorDocente(Integer idDocente) {
        List<FranjaHoraria> franjasHorarias = this.objGestionarFranjaHorariaGateway.listarPorDocente(idDocente);
        return franjasHorarias;
    }
}
