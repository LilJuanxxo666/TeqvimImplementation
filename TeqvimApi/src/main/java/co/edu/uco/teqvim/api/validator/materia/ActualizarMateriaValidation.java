package co.edu.uco.teqvim.api.validator.materia;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.dto.MateriaDTO;

public final class ActualizarMateriaValidation implements Validation<MateriaDTO>{

	private ActualizarMateriaValidation() {
		super();
	}

	public static Result validate(final MateriaDTO data) {
		return new ActualizarMateriaValidation().execute(data);
	}
	
	@Override
	public Result execute(MateriaDTO data) {
		return null;
	}
}
