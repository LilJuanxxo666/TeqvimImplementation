package co.edu.uco.teqvim.api.validator.respuesta.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class NombreValidation implements Validation<String> {

	private NombreValidation() {
		super();
	}

	public static Result validate(String data) {
		return new NombreValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();

		if (UtilText.getUtilText().isNull(data)) {
			result.addMessage("El nombre de la respuesta no puede estar vacío");
		}

		return result;
	}

}
