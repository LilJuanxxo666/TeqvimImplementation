package co.edu.uco.teqvim.api.validator.periodoacademico.common;

import co.edu.uco.teqvim.api.validator.Result;

import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.PeriodoAcademicoValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public final class NombresPeriodoAcademicoValidation implements Validation<String>{
	
	private NombresPeriodoAcademicoValidation() {
		super();
	}

	public static Result validate(String data) {
		return new NombresPeriodoAcademicoValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();
		if (UtilText.getUtilText().isEmpty(data)) {
			result.addMessage(PeriodoAcademicoValidatorMessage.NOMBRE_EMPTY_MESSAGE);
		}
		if(UtilText.getUtilText().applyTrim(data).length() > 20){
			result.addMessage(PeriodoAcademicoValidatorMessage.NOMBRE_LENGTH_MESSAGE);
		}
		return result;
	}
}
