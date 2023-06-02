package co.edu.uco.teqvim.api.validator.evento.common;

import co.edu.uco.teqvim.api.validator.Result;
import co.edu.uco.teqvim.api.validator.Validation;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.dto.TipoDuracionEventoDTO;

public class TipoDuracionEventoValidation implements Validation<TipoDuracionEventoDTO> {
	
	private TipoDuracionEventoValidation() {
		super();
	}
	
	public static final Result validate(final TipoDuracionEventoDTO data) {
		return new TipoDuracionEventoValidation().execute(data);
	}
	
	@Override
    public final Result execute(TipoDuracionEventoDTO data) {
        var result = Result.create();

        if (UtilObject.isNull(data)) {
            result.addMessage("No es posible continuar con el tipo de la duracion del evento vacío");
        } else {
            if (UtilObject.isNull(data.getIdentificador())) {
                result.addMessage("No es posible continuar con el identificador del tipo de duracion del evento vacío");
            }
            if (UtilText.getUtilText().isNull(data.getNombre())) {
                result.addMessage("El nombre del tipo de duracion evento no puede estar vacío");
            }
            if (UtilText.getUtilText().isNull(data.getDescripcion())) {
                result.addMessage("La descripcion del tipo de duracion de un evento no puede estar vacía");
            }
        }

        return result;
    }

}

