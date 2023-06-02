package co.edu.uco.teqvim.api.validator.respuesta;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.api.validator.respuesta.common.DescripcionValidation;
import co.edu.uco.teqvim.api.validator.respuesta.common.NombreValidation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.RespuestaDTO;

public class CrearRespuestaValidation implements Validation<RespuestaDTO> {

	private CrearRespuestaValidation() {
		super();
	}

	public static Result validate(final RespuestaDTO data) {
		return new CrearRespuestaValidation().execute(data);
	}

	@Override
	public Result execute(final RespuestaDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible generar una respuesta con los datos vacios");
		} else {

			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
		}

		return result;
	}

}