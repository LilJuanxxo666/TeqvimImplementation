package co.edu.uco.teqvim.api.validator.evento;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.api.validator.evento.common.DescripcionValidation;
import co.edu.uco.teqvim.api.validator.evento.common.EstadoEventoValidation;
import co.edu.uco.teqvim.api.validator.evento.common.EstudianteValidation;
import co.edu.uco.teqvim.api.validator.evento.common.FechaValidation;
import co.edu.uco.teqvim.api.validator.evento.common.TipoDuracionEventoValidation;
import co.edu.uco.teqvim.api.validator.evento.common.TipoEventoValidation;
import co.edu.uco.teqvim.api.validator.evento.common.TituloValidation;
import co.edu.uco.teqvim.api.validator.general.common.IdentificadorValidation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.dto.EventoDTO;

public class ActualizarEventoValidation implements Validation<EventoDTO> {

	private ActualizarEventoValidation() {
		super();
	}

	public static Result validate(final EventoDTO data) {
		return new ActualizarEventoValidation().execute(data);
	}

	@Override
	public Result execute(final EventoDTO data) {
		var result = Result.create();

		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible modificar el evento con los datos vacíos");
		} else {
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(TituloValidation.validate(data.getTitulo()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
			result.addMessages(FechaValidation.validate(data.getFechaInicio()).getMessages());
			result.addMessages(FechaValidation.validate(data.getFechaFin()).getMessages());
			result.addMessages(TipoDuracionEventoValidation.validate(data.getDuracionEvento()).getMessages());
			result.addMessages(EstadoEventoValidation.validate(data.getEstado()).getMessages());
			result.addMessages(TipoEventoValidation.validate(data.getTipoEvento()).getMessages());
			result.addMessages(EstudianteValidation.validate(data.getEstudiante()).getMessages());
		}

		return result;
	}

}
