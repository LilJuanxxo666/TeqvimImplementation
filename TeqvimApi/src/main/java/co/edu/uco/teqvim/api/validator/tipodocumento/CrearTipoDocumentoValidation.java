package co.edu.uco.teqvim.api.validator.tipodocumento;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.tipodocumento.common.DescripcionValidation;
import co.edu.uco.teqvim.api.validator.tipodocumento.common.NombreValidation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.TipoDocumentoDTO;

public class CrearTipoDocumentoValidation implements Validation<TipoDocumentoDTO> {

	private CrearTipoDocumentoValidation() {
		super();
	}

	public static Result validate(final TipoDocumentoDTO data) {
		return new CrearTipoDocumentoValidation().execute(data);
	}

	@Override
	public Result execute(final TipoDocumentoDTO data) {
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