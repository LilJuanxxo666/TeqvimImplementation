package co.edu.uco.teqvim.api.validator.estadoestudiante;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.estadoestudiante.common.DescripcionValidation;
import co.edu.uco.teqvim.api.validator.estadoestudiante.common.NombreValidation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.EstadoEstudianteDTO;

public class CrearEstadoEstudianteValidation implements Validation<EstadoEstudianteDTO> {

	private CrearEstadoEstudianteValidation() {
		super();
	}

	public static Result validate(final EstadoEstudianteDTO data) {
		return new CrearEstadoEstudianteValidation().execute(data);
	}

	@Override
	public Result execute(final EstadoEstudianteDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible generar un estado estudiante con los datos vacios");
		} else {

			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
		}

		return result;
	}

}