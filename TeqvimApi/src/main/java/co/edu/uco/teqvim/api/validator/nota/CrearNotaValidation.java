package co.edu.uco.teqvim.api.validator.nota;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.dto.NotaDTO;

public final class CrearNotaValidation implements Validation<NotaDTO>{
	
	private CrearNotaValidation() {
		super();
	}

	public static Result validate(final NotaDTO data) {
		return new CrearNotaValidation().execute(data);
	}
	
	@Override
	public Result execute(NotaDTO data) {
		return null;
	}

}
