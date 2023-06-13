package co.edu.uco.teqvim.api.validator.estudiante;

import co.edu.uco.teqvim.api.validator.Result;

import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.estudiante.common.ContrasenaValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.CorreoValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.FechaNacimientoValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.NombresVaciosEstudianteValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.NombresEstudianteValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.NumeroDocumentoValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.NumeroTelefonicoValidation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudianteValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.EstudianteDTO;

public final class ActualizarEstudianteValidation implements Validation<EstudianteDTO> {

	private ActualizarEstudianteValidation() {
		super();
	}

	public static Result validate(final EstudianteDTO data) {
		return new ActualizarEstudianteValidation().execute(data);
	}

	@Override
	public Result execute(final EstudianteDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage(EstudianteValidatorMessage.UPDATE_ESTUDIANTE_OBJECT_NULL_MESSAGE);
		} else {
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NombresEstudianteValidation.validate(data.getPrimerNombre()).getMessages());
			result.addMessages(NombresVaciosEstudianteValidation.validate(data.getSegundoNombre()).getMessages());
			result.addMessages(NombresEstudianteValidation.validate(data.getPrimerApellido()).getMessages());
			result.addMessages(NombresVaciosEstudianteValidation.validate(data.getSegudoApellido()).getMessages());
			result.addMessages(NumeroTelefonicoValidation.validate(data.getNumeroTelefonico()).getMessages());
			result.addMessages(CorreoValidation.validate(data.getCorreo()).getMessages());
			result.addMessages(ContrasenaValidation.validate(data.getContrasena()).getMessages());
			result.addMessages(FechaNacimientoValidation.validate(data.getFechaNacimiento()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getTipoDocumento().getIdentificador()).getMessages());
			result.addMessages(NumeroDocumentoValidation.validate(data.getNumeroDocumento()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getConfirmacionCorreo().getIdentificador()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getPais().getIdentificador()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getEstado().getIdentificador()).getMessages());
		}

		return result;
	}
}