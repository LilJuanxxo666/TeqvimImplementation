package co.edu.uco.teqvim.api.validator.pais;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.pais.common.NombreValidation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.PaisDTO;

public class CrearPaisValidation implements Validation<PaisDTO> {

	private CrearPaisValidation() {
		super();
	}

	public static Result validate(final PaisDTO data) {
		return new CrearPaisValidation().execute(data);
	}

	@Override
	public Result execute(final PaisDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible generar un pais con los datos vacios");
		} else {

			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());

		}

		return result;
	}

}