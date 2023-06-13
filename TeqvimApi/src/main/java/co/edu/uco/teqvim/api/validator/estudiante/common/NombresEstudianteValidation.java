package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudianteValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class NombresEstudianteValidation implements Validation<String>{
	
	private NombresEstudianteValidation() {
		super();
	}

	public static Result validate(String data) {
		return new NombresEstudianteValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();
		if (UtilText.getUtilText().isEmpty(data)) {
			result.addMessage(EstudianteValidatorMessage.NOMBRE_EMPTY_MESSAGE);
		}
		if(UtilText.getUtilText().applyTrim(data).length() > 10){
			result.addMessage(EstudianteValidatorMessage.NOMBRE_LENGTH_MESSAGE);
		}
		return result;
	}
}
