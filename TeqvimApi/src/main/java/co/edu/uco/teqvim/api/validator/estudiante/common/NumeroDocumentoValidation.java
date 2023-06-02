package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
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

		if (UtilText.getUtilText().isNull(data)) {
			result.addMessage("El numero de documento del estudiante no puede estar vacío");
		}

		return result;
	}

}
