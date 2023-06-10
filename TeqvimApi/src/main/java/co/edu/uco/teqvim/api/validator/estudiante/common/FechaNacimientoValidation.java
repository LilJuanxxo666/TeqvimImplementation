package co.edu.uco.teqvim.api.validator.estudiante.common;

import java.time.LocalDate;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudianteValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilDate;

public class FechaNacimientoValidation implements Validation<LocalDate> {

	private FechaNacimientoValidation() {
		super();
	}

	public static Result validate(LocalDate data) {
		return new FechaNacimientoValidation().execute(data);
	}

	@Override
	public Result execute(LocalDate data) {
		Result result = Result.create();

		if (UtilDate.isDefaultDateOrNull(data)) {
			result.addMessage(EstudianteValidatorMessage.FECHA_NACIMIENTO_EMPTY_LESS_MESSAGE);
		}
		else if (data.isAfter(LocalDate.now())) {
			result.addMessage(EstudianteValidatorMessage.FECHA_NACIMIENTO_IS_AFTER_LESS_MESSAGE);
		}
		return result;
	}

}
