package co.edu.uco.teqvim.api.validator.periodoacademico.common;

import java.time.LocalDate;
import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.PeriodoAcademicoValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilDate;

public final class FechaInicioValidation implements Validation<LocalDate> {

	private FechaInicioValidation() {
		super();
	}

	public static Result validate(LocalDate data) {
		return new FechaInicioValidation().execute(data);
	}

	@Override
	public Result execute(LocalDate data) {
		Result result = Result.create();

		if (UtilDate.isDefaultDateOrNull(data)) {
			result.addMessage(PeriodoAcademicoValidatorMessage.FECHA_INICIO_EMPTY_MESSAGE);
		}
		return result;
	}
}
