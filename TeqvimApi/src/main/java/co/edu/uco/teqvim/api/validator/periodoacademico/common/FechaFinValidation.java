package co.edu.uco.teqvim.api.validator.periodoacademico.common;

import java.time.LocalDate;


import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.Messages.PeriodoAcademicoValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilDate;

public class FechaFinValidation implements Validation<LocalDate> {

	private FechaFinValidation() {
		super();
	}

	public static Result validate(LocalDate data) {
		return new FechaFinValidation().execute(data);
	}

	@Override
	public Result execute(LocalDate data) {
		Result result = Result.create();

		if (UtilDate.isDefaultDateOrNull(data)) {
			result.addMessage(PeriodoAcademicoValidatorMessage.FECHA_FIN_EMPTY_MESSAGE);
		}
		return result;
	}
}
