package co.edu.unicauca.asae.tallerhexagonal.commons.controladorExcepciones.estructuraExcepciones;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CodigoError {

	ERROR_GENERICO("GC-0001", "ERROR GENERICO"),
	ENTIDAD_YA_EXISTE("GC-0002", "ERROR ENTIDAD YA EXISTE"),
	ENTIDAD_NO_ENCONTRADA("GC-003", "Entidad no encontrada"),
	VIOLACION_REGLA_DE_NEGOCIO("GC-0004", "Regla de negocio violada"),
	CREDENCIALES_INVALIDAS(
		"GC-0005",
		"Error al iniciar sesión, compruebe sus credenciales y vuelva a intentarlo"
	),
	USUARIO_DESHABILITADO(
		"GC-0006",
		"El usuario no ha sido verificado, por favor revise su correo para verificar su cuenta"
	);

	private final String codigo;
	private final String llaveMensaje;
}
