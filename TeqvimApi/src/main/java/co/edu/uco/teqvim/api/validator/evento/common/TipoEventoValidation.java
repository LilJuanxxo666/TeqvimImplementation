package co.edu.uco.teqvim.api.validator.evento.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.dto.TipoEventoDTO;

public class TipoEventoValidation implements Validation<TipoEventoDTO> {

	private TipoEventoValidation() {
		super();
	}

	public static final Result validate(final TipoEventoDTO data) {
		return new TipoEventoValidation().execute(data);
	}

	@Override
	public final Result execute(TipoEventoDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el tipo del evento vacío");
		} else {
			if (UtilObject.isNull(data.getIdentificador())) {
				result.addMessage("No es posible continuar con el identificador del tipo del evento vacío");
			}
			if (UtilText.getUtilText().isNull(data.getNombre())) {
				result.addMessage("El nombre del tipo del evento no puede estar vacío");
			}
			if (UtilText.getUtilText().isNull(data.getDescripcion())) {
				result.addMessage("La descripcion del tipo de un evento no puede estar vacía");
			}
		}

		return result;
	}

}
