package co.edu.uco.teqvim.api.validator.estadoevento;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.estadoevento.common.DescripcionValidation;
import co.edu.uco.teqvim.api.validator.estadoevento.common.NombreValidation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.EstadoEventoDTO;

public class CrearEstadoEventoValidation implements Validation<EstadoEventoDTO> {

	private CrearEstadoEventoValidation() {
		super();
	}

	public static Result validate(final EstadoEventoDTO data) {
		return new CrearEstadoEventoValidation().execute(data);
	}

	@Override
	public Result execute(final EstadoEventoDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible generar un estado evento con los datos vacios");
		} else {

			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
		}

		return result;
	}

}