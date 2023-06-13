package co.edu.uco.teqvim.api.validator.periodoacademico;

import co.edu.uco.teqvim.api.validator.Result;


import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.api.validator.periodoacademico.common.FechaFinValidation;
import co.edu.uco.teqvim.api.validator.periodoacademico.common.FechaInicioValidation;
import co.edu.uco.teqvim.api.validator.periodoacademico.common.NombresPeriodoAcademicoValidation;
import co.edu.uco.teqvim.api.validator.periodoacademico.common.PromedioPeriodoValidator;
import co.edu.uco.teqvim.crosscutting.utils.Messages.PeriodoAcademicoValidatorMessage;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.PeriodoAcademicoDTO;

public final class CrearPeriodoAcademicoValidation implements Validation<PeriodoAcademicoDTO> {

	private CrearPeriodoAcademicoValidation() {
		super();
	}

	public static Result validate(final PeriodoAcademicoDTO data) {
		return new CrearPeriodoAcademicoValidation().execute(data);
	}

	@Override
	public Result execute(final PeriodoAcademicoDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage(PeriodoAcademicoValidatorMessage.CREATE_ESTUDIANTE_OBJECT_NULL_MESSAGE);
		} else {
			result.addMessages(NombresPeriodoAcademicoValidation.validate(data.getNombre()).getMessages());
			result.addMessages(FechaInicioValidation.validate(data.getFechaInicio()).getMessages());
			result.addMessages(FechaFinValidation.validate(data.getFechaFin()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getEstado().getIdentificador()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getTipoPeriodo().getIdentificador()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getEstudiante().getIdentificador()).getMessages());
			result.addMessages(PromedioPeriodoValidator.validate(data.getPromedioPeriodo()).getMessages());
		}
		return result;
	}

}
