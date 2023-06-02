package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.dto.PaisDTO;

public class PaisValidation implements Validation<PaisDTO> {

	private PaisValidation() {
		super();
	}

	public static final Result validate(final PaisDTO data) {
		return new PaisValidation().execute(data);
	}

	@Override
	public final Result execute(PaisDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el pais vacío");
		} else {
			if (UtilObject.isNull(data.getIdentificador())) {
				result.addMessage("No es posible continuar con el identificador del pais vacío");
			}
			if (UtilText.getUtilText().isNull(data.getNombre())) {
				result.addMessage("El nombre del pais no puede estar vacío");
			}

		}

		return result;
	}
}
