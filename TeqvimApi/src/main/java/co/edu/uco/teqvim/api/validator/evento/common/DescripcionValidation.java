package co.edu.uco.teqvim.api.validator.evento.common;

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
			result.addMessage("El nombre de la agenda no puede estar vacío");
		}else if ((UtilText.getUtilText().applyTrim(data)).length() == 250) {
			result.addMessage("El titulo del evento no puede superar los 50 caracteres");
		}

		return result;
	}

}
