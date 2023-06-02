package co.edu.uco.teqvim.api.validator.tipodocumento.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class DescripcionValidation implements Validation<String> {

	private DescripcionValidation() {
		super();
	}

	public static Result validate(String data) {
		return new DescripcionValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();

		if (UtilText.getUtilText().isNull(data)) {
			result.addMessage("La descripcion del tipo de documento no puede estar vacío");
		}

		return result;
	}
}
