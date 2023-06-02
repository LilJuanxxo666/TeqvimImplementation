package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class NumeroTelefonicoValidation implements Validation<String>{
	
	private NumeroTelefonicoValidation() {
		super();
	}

	public static Result validate(String data) {
		return new NumeroTelefonicoValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();

		if (UtilText.getUtilText().isNull(data)) {
			result.addMessage("El numero telefonico del estudiante no puede estar vacío");
		}

		return result;
	}

}
