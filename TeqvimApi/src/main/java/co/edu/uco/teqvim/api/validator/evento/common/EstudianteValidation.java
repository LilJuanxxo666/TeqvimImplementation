package co.edu.uco.teqvim.api.validator.evento.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.dto.EstudianteDTO;

public class EstudianteValidation implements Validation<EstudianteDTO> {

	private EstudianteValidation() {
		super();
	}

	public static final Result validate(final EstudianteDTO data) {
		return new EstudianteValidation().execute(data);
	}

	@Override
	public final Result execute(EstudianteDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el estudiante vacío");
		} else {
			if (UtilObject.isNull(data.getIdentificador())) {
				result.addMessage("No es posible continuar con el identificador del estudiante vacío");
			}
			if (UtilText.getUtilText().isNull(data.getPrimerNombre())) {
				result.addMessage("El primer nombre del estudiante no puede estar vacío");
			}
			if (UtilText.getUtilText().isNull(data.getPrimerApellido())) {
				result.addMessage("El primer apellido del estudiante no puede estar vacío");
			}
			if (UtilText.getUtilText().isNull(data.getSegundoApellido())) {
				result.addMessage("El segundo apellido del estudiante no puede estar vacío");
			}
			if (UtilText.getUtilText().isNull(data.getNumeroTelefonico())) {
				result.addMessage("El numero telefonico del estudiante no puede estar vacío");
			}
			if (UtilText.getUtilText().isNull(data.getCorreo())) {
				result.addMessage("El correo del estudiante no puede estar vacío");
			}
			if (UtilText.getUtilText().isNull(data.getContrasena())) {
				result.addMessage("La contraseña del estudiante no puede estar vacío");
			}
			if (UtilObject.isNull(data.getFechaNacimiento())) {
				result.addMessage("El tipo de documento del estudiante  no puede estar vacío");
			}
			if (UtilObject.isNull(data.getTipoDocumento())) {
				result.addMessage("la fecha de nacimiento del estudiante no puede estar vacío");
			}
			if (UtilText.getUtilText().isNull(data.getNumeroDocumento())) {
				result.addMessage("El número de documento del estudiante no puede estar vacía");
			}
			if (UtilObject.isNull(data.getConfirmacionCorreo())) {
				result.addMessage("La confirmacion del correo del estudiante no puede estar vacío");
			}
			if (UtilObject.isNull(data.getPais())) {
				result.addMessage("El pais del estudiante no puede estar vacía");
			}
			if (UtilObject.isNull(data.getEstado())) {
				result.addMessage("El estado del estudiante no puede estar vacío");
			}

		}

		return result;
	}

}
