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
import co.edu.uco.teqvim.api.validator.estadoevento.CrearEstadoEventoValidation;
import co.edu.uco.teqvim.business.facade.EstadoEventoFacade;
import co.edu.uco.teqvim.business.facade.impl.EstadoEventoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.dto.EstadoEventoDTO;

@RestController
@RequestMapping("teqvim/api/v1/estadoevento")
public final class EstadoEventoController {

	private Logger log = LoggerFactory.getLogger(EstadoEventoController.class);
	private EstadoEventoFacade facade;

	@GetMapping("/dummy")
	public EstadoEventoDTO dummy() {
		return EstadoEventoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<EstadoEventoDTO>> list(@RequestBody EstadoEventoDTO dto) {

		facade = new EstadoEventoFacadeImpl();
		List<EstadoEventoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add("Estado evento consultadas correctamente");

		Response<EstadoEventoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public EstadoEventoDTO getById(@PathVariable UUID id) {
		return EstadoEventoDTO.create().setIdentificador(id);
	}

	@PostMapping
	public ResponseEntity<Response<EstadoEventoDTO>> create(@RequestBody EstadoEventoDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EstadoEventoDTO>();

		try {
			var result = CrearEstadoEventoValidation.validate(dto);

			if (result.getMessages().isEmpty()) {
				facade = new EstadoEventoFacadeImpl();
				facade.register(dto);
				response.getMessages().add("El estado del evento se ha creado correctamente");
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
