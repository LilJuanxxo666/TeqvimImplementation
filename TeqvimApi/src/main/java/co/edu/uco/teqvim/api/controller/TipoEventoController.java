package co.edu.uco.teqvim.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.teqvim.api.controller.response.Response;
import co.edu.uco.teqvim.api.validator.tipoevento.CrearTipoEventoValidation;
import co.edu.uco.teqvim.business.facade.TipoEventoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoEventoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.dto.TipoEventoDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipoevento")
public final class TipoEventoController {

	private Logger log = LoggerFactory.getLogger(TipoEventoController.class);
	private TipoEventoFacade facade;

	@GetMapping("/dummy")
	public TipoEventoDTO dummy() {
		return TipoEventoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoEventoDTO>> list(@RequestBody TipoEventoDTO dto) {

		facade = new TipoEventoFacadeImpl();
		List<TipoEventoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add("Tipos de evento consultadas correctamente");

		Response<TipoEventoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public TipoEventoDTO getById(@PathVariable UUID id) {
		return TipoEventoDTO.create().setIdentificador(id);
	}

	@PostMapping
	public ResponseEntity<Response<TipoEventoDTO>> create(@RequestBody TipoEventoDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<TipoEventoDTO>();

		try {
			var result = CrearTipoEventoValidation.validate(dto);

			if (result.getMessages().isEmpty()) {
				facade = new TipoEventoFacadeImpl();
				facade.register(dto);
				response.getMessages().add("La agenda se ha creado correctamente");
			} else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}

		} catch (final TeqvimException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat(exception.getTechnicalMessage()), exception);

			exception.printStackTrace();
		} catch (final Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add(
					"Se ha presentado un problema inesperado. Por favor, intenta de nuevo y si el problema persiste, contacta al administrador de la aplicación");
			log.error("Se ha presentado un problema inesperado. Por favor validar la consola de errores...");
			exception.printStackTrace();
		}

		return new ResponseEntity<>(response, statusCode);
	}
}
