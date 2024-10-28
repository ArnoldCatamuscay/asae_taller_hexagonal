package co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.gateway;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.tallerhexagonal.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.tallerhexagonal.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepositorioInt;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionarFranjaHorariaGatewayImplAdapter implements GestionarFranjaHorariaGatewayIntPort {

        private final FranjaHorariaRepositorioInt objFranjaHorariaRepository;
        private final ModelMapper franjaHorariaModelMapper;
        private final GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGatewayIntPort;
        private final GestionarCursoGatewayIntPort objGestionarCursoGatewayIntPort;

        @Override
        public FranjaHoraria crearFranjaHoraria(FranjaHoraria objFranjaHoraria) {
                FranjaHorariaEntity objFranjaHorariaEntity = this.franjaHorariaModelMapper.map(objFranjaHoraria,
                                FranjaHorariaEntity.class);
                Curso objCurso = this.objGestionarCursoGatewayIntPort.findById(objFranjaHoraria.getCurso().getId());
                CursoEntity objCursoEntity = this.franjaHorariaModelMapper.map(objCurso, CursoEntity.class);
                EspacioFisico objEspacioFisico = this.objGestionarEspacioFisicoGatewayIntPort
                                .findById(objFranjaHoraria.getEspacioFisico().getId());
                EspacioFisicoEntity objEspacioFisicoEntity = this.franjaHorariaModelMapper.map(objEspacioFisico,
                                EspacioFisicoEntity.class);
                objFranjaHorariaEntity.setObjCurso(objCursoEntity);
                objFranjaHorariaEntity.setObjEspacioFisico(objEspacioFisicoEntity);
                FranjaHorariaEntity objFranjaHorariaEntityRegistrado = this.objFranjaHorariaRepository
                                .save(objFranjaHorariaEntity);
                FranjaHoraria objFranjaHorariaRespuesta = this.franjaHorariaModelMapper.map(
                                objFranjaHorariaEntityRegistrado,
                                FranjaHoraria.class);
                return objFranjaHorariaRespuesta;
        }

}
