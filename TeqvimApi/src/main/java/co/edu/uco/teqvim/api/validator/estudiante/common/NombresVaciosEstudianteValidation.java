package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudianteValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class NombresVaciosEstudianteValidation implements Validation<String>{
	
	private NombresVaciosEstudianteValidation() {
		super();
	}

	public static Result validate(String data) {
		return new NombresVaciosEstudianteValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();
		if(UtilText.getUtilText().applyTrim(data).length() > 10){
			result.addMessage(EstudianteValidatorMessage.NOMBRE_LENGTH_MESSAGE);
		}
		return result;
	}
}
