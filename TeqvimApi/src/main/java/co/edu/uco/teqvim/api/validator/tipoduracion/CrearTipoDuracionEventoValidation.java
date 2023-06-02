package co.edu.uco.teqvim.api.validator.tipoduracion;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.tipoduracion.common.DescripcionValidation;
import co.edu.uco.teqvim.api.validator.tipoduracion.common.NombreValidation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.TipoDuracionEventoDTO;

public class CrearTipoDuracionEventoValidation implements Validation<TipoDuracionEventoDTO> {

	private CrearTipoDuracionEventoValidation() {
		super();
	}

	public static Result validate(final TipoDuracionEventoDTO data) {
		return new CrearTipoDuracionEventoValidation().execute(data);
	}

	@Override
	public Result execute(final TipoDuracionEventoDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible generar un tipo de documento con los datos vacios");
		} else {

			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
		}

		return result;
	}

}