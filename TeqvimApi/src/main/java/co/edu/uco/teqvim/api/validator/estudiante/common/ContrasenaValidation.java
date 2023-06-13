package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudianteValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class ContrasenaValidation implements Validation<String>{
	
	private ContrasenaValidation() {
		super();
	}

	public static Result validate(String data) {
		return new ContrasenaValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();

		if (UtilText.getUtilText().isNull(data)) {
			result.addMessage(EstudianteValidatorMessage.CONTRASENA_EMPTY_MESSAGE);
		}
		else if (!UtilText.passwordStringIsValid(data)){
			result.addMessage(EstudianteValidatorMessage.CONTRASENA_VALID_MESSAGE);
		}
		else if (UtilText.getUtilText().applyTrim(data).length() > 16) {
			result.addMessage(EstudianteValidatorMessage.CONTRASENA_LENGHT_MORE_MESSAGE);
		}
		else if (UtilText.getUtilText().applyTrim(data).length() < 8) {
			result.addMessage(EstudianteValidatorMessage.CONTRASENA_LENGHT_LESS_MESSAGE);
		}
		return result;
	}

}
