package co.edu.uco.teqvim.api.validator.evento.common;

import java.time.LocalDate;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;

public class FechaValidation implements Validation<LocalDate> {

	private FechaValidation() {
		super();
	}

	public static Result validate(LocalDate data) {
		return new FechaValidation().execute(data);
	}

	@Override
	public Result execute(LocalDate data) {
		Result result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("La fecha del evento no puede estar vacío");
		}

		return result;
	}

}
