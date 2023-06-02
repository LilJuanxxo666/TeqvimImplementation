package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
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
			result.addMessage("La contraseña del estudiante no puede estar vacío");
		}

		return result;
	}

}
