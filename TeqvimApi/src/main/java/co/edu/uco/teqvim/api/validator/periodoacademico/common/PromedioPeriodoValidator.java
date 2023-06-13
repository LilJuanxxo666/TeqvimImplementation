package co.edu.uco.teqvim.api.validator.periodoacademico.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.Messages.PeriodoAcademicoValidatorMessage;

public final class PromedioPeriodoValidator implements Validation<Double>{

	private PromedioPeriodoValidator() {
		super();
	}

	public static Result validate(Double data) {
		return new PromedioPeriodoValidator().execute(data);
	}

	@Override
	public Result execute(Double data) {
		Result result = Result.create();

		if (UtilNumber.getUtilNumber().isNull(data)) {
			result.addMessage(PeriodoAcademicoValidatorMessage.PROMEDIO_PERIODO_EMPTY_MESSAGE);
		}
		else if (UtilNumber.getUtilNumber().getDefault(data).doubleValue() > 5) {
			result.addMessage(PeriodoAcademicoValidatorMessage.PROMEDIO_PERIODO_MORE_MESSAGE);
		}
		else if (UtilNumber.getUtilNumber().getDefault(data).doubleValue() < 0 ) {
			result.addMessage(PeriodoAcademicoValidatorMessage.PROMEDIO_PERIODO_LESS_MESSAGE);
		}
		else if (!UtilNumber.getUtilNumber().isValidDoubleToNote(data)) {
			result.addMessage(PeriodoAcademicoValidatorMessage.PROMEDIO_PERIODO_FORMAT_MESSAGE);
		}
		else if (UtilNumber.getUtilNumber().getDefault(data).toString().length() > 3) {
			result.addMessage(PeriodoAcademicoValidatorMessage.PROMEDIO_PERIODO_FORMAT_MESSAGE);
		}
		return result;
	}
}

