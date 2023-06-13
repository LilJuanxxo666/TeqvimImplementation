package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudianteValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class CorreoValidation implements Validation<String>{
	
	private CorreoValidation() {
		super();
	}

	public static Result validate(String data) {
		return new CorreoValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();

		if (UtilText.getUtilText().isEmpty(data)) {
			result.addMessage(EstudianteValidatorMessage.CORREO_EMPTY_MESSAGE);
		}
		else if (!UtilText.emailStringIsValid(data)) {
			result.addMessage(EstudianteValidatorMessage.CORREO_VALID_MESSAGE);
		}
		return result;
	}

}
