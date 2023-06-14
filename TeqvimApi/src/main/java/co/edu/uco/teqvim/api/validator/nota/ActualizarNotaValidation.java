package co.edu.uco.teqvim.api.validator.nota;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.dto.NotaDTO;

public final class ActualizarNotaValidation implements Validation<NotaDTO> {

	private ActualizarNotaValidation() {
		super();
	}

	public static Result validate(final NotaDTO data) {
		return new ActualizarNotaValidation().execute(data);
	}
	
	@Override
	public Result execute(NotaDTO data) {
		return null;
	}

}
