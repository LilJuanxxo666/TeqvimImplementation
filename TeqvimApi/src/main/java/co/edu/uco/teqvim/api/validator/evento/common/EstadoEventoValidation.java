package co.edu.uco.teqvim.api.validator.evento.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.dto.EstadoEventoDTO;

public class EstadoEventoValidation implements Validation<EstadoEventoDTO> {

	private EstadoEventoValidation() {
		super();
	}

	public static final Result validate(final EstadoEventoDTO data) {
		return new EstadoEventoValidation().execute(data);
	}

	@Override
	public final Result execute(EstadoEventoDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el estado del evento vacío");
		} else {
			if (UtilObject.isNull(data.getIdentificador())) {
				result.addMessage("No es posible continuar con el identificador del estado del evento vacío");
			}
			if (UtilText.getUtilText().isNull(data.getNombre())) {
				result.addMessage("El nombre del estado del evento no puede estar vacío");
			}
			if (UtilText.getUtilText().isNull(data.getDescripcion())) {
				result.addMessage("La descripcion del estado de un evento no puede estar vacía");
			}
		}

		return result;
	}

}
