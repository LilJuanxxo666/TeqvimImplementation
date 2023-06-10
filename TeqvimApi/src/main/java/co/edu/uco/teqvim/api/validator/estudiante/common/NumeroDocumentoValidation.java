package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudianteValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class NumeroDocumentoValidation implements Validation<String>{
	
	private NumeroDocumentoValidation() {
		super();
	}

	public static Result validate(String data) {
		return new NumeroDocumentoValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();

		if (UtilText.getUtilText().isEmpty(data)){
			result.addMessage(EstudianteValidatorMessage.FECHA_NACIMIENTO_EMPTY_LESS_MESSAGE);
		}
		else if (UtilText.getUtilText().applyTrim(data).length() > 15) {
			result.addMessage(EstudianteValidatorMessage.FECHA_NACIMIENTO_IS_AFTER_LESS_MESSAGE);
		}
		return result;
	}
}
