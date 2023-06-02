package co.edu.uco.teqvim.api.validator.tipoevento;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.tipoevento.common.DescripcionValidation;
import co.edu.uco.teqvim.api.validator.tipoevento.common.NombreValidation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.TipoEventoDTO;

public class CrearTipoEventoValidation implements Validation<TipoEventoDTO> {

	private CrearTipoEventoValidation() {
		super();
	}

	public static Result validate(final TipoEventoDTO data) {
		return new CrearTipoEventoValidation().execute(data);
	}

	@Override
	public Result execute(final TipoEventoDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible generar un tipo de evento con los datos vacios");
		} else {

			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
		}

		return result;
	}

}