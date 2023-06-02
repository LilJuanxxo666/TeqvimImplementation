package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class NombresValidation implements Validation<String>{
	
	private NombresValidation() {
		super();
	}

	public static Result validate(String data) {
		return new NombresValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();

		if (UtilText.getUtilText().isNull(data)) {
			result.addMessage("El nombre del estudiante no puede estar vacío");
		}

		return result;
	}

}
