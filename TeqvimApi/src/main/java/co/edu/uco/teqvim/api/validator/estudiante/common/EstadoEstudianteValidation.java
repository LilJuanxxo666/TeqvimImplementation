package co.edu.uco.teqvim.api.validator.estudiante.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.dto.EstadoEstudianteDTO;

public class EstadoEstudianteValidation implements Validation<EstadoEstudianteDTO> {

	private EstadoEstudianteValidation() {
		super();
	}

	public static final Result validate(final EstadoEstudianteDTO data) {
		return new EstadoEstudianteValidation().execute(data);
	}

	@Override
	public final Result execute(EstadoEstudianteDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el estado del estudiante vacío");
		} else {
			if (UtilObject.isNull(data.getIdentificador())) {
				result.addMessage("No es posible continuar con el identificador del estado del estudiante vacío");
			}
			if (UtilText.getUtilText().isNull(data.getNombre())) {
				result.addMessage("El nombre del estado del estudiante no puede estar vacío");
			}
			if (UtilText.getUtilText().isNull(data.getDescripcion())) {
				result.addMessage("La descripcion del estado del estudiante no puede estar vacía");
			}
		}

		return result;
	}
}
