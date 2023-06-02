package co.edu.uco.teqvim.api.validator.estudiante;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.estudiante.common.ConfirmacionCorreoValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.ContrasenaValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.CorreoValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.EstadoEstudianteValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.FechaValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.NombresValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.NumeroDocumentoValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.NumeroTelefonicoValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.PaisValidation;
import co.edu.uco.teqvim.api.validator.estudiante.common.TipoDocumentoValidation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.EstudianteDTO;

public class CrearEstudianteValidation implements Validation<EstudianteDTO> {

	private CrearEstudianteValidation() {
		super();
	}

	public static Result validate(final EstudianteDTO data) {
		return new CrearEstudianteValidation().execute(data);
	}

	@Override
	public Result execute(final EstudianteDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible crear un estudiante con los datos vacíos");
		} else {

			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NombresValidation.validate(data.getPrimerNombre()).getMessages());
			result.addMessages(NombresValidation.validate(data.getSegundoNombre()).getMessages());
			result.addMessages(NombresValidation.validate(data.getPrimerApellido()).getMessages());
			result.addMessages(NombresValidation.validate(data.getSegundoApellido()).getMessages());
			result.addMessages(NumeroTelefonicoValidation.validate(data.getNumeroTelefonico()).getMessages());
			result.addMessages(CorreoValidation.validate(data.getCorreo()).getMessages());
			result.addMessages(ContrasenaValidation.validate(data.getContrasena()).getMessages());
			result.addMessages(FechaValidation.validate(data.getFechaNacimiento()).getMessages());
			result.addMessages(TipoDocumentoValidation.validate(data.getTipoDocumento()).getMessages());
			result.addMessages(NumeroDocumentoValidation.validate(data.getNumeroDocumento()).getMessages());
			result.addMessages(ConfirmacionCorreoValidation.validate(data.getConfirmacionCorreo()).getMessages());
			result.addMessages(PaisValidation.validate(data.getPais()).getMessages());
			result.addMessages(EstadoEstudianteValidation.validate(data.getEstado()).getMessages());
		}

		return result;
	}

}
