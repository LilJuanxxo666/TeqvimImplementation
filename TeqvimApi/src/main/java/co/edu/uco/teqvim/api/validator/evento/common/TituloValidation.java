package co.edu.uco.teqvim.api.validator.evento.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;

public class TituloValidation implements Validation<String> {

	private TituloValidation() {
		super();
	}

	public static Result validate(String data) {
		return new TituloValidation().execute(data);
	}

	@Override
	public Result execute(String data) {
		Result result = Result.create();

		if (UtilText.getUtilText().isNull(data)) {
			result.addMessage("El titulo del evento no puede estar vacío");
		}else if ((UtilText.getUtilText().applyTrim(data)).length() == 50) {
			result.addMessage("El titulo del evento no puede superar los 50 caracteres");
		}

		return result;
	}

}
