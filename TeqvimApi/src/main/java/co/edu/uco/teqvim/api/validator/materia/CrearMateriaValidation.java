package co.edu.uco.teqvim.api.validator.materia;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.dto.MateriaDTO;

public final class CrearMateriaValidation implements Validation<MateriaDTO> {

	private CrearMateriaValidation() {
		super();
	}

	public static Result validate(final MateriaDTO data) {
		return new CrearMateriaValidation().execute(data);
	}
	
	@Override
	public Result execute(MateriaDTO data) {
		return null;
	}
}
