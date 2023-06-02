package co.edu.uco.teqvim.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.teqvim.api.controller.response.Response;
import co.edu.uco.teqvim.api.validator.evento.ActualizarEventoValidation;
import co.edu.uco.teqvim.api.validator.evento.CrearEventoValidation;
import co.edu.uco.teqvim.business.facade.EventoFacade;
import co.edu.uco.teqvim.business.facade.impl.EventoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.dto.EventoDTO;

@RestController
@RequestMapping("teqvim/api/v1/evento")
public final class EventoController {

	private Logger log = LoggerFactory.getLogger(EventoController.class);
	private EventoFacade facade;

	@GetMapping("/dummy")
	public EventoDTO dummy() {
		return EventoDTO.create();
	}

	@GetMapping("/list")
	public ResponseEntity<Response<EventoDTO>> list(@RequestBody EventoDTO dto) {

		facade = new EventoFacadeImpl();
		List<EventoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add("Eventos consultadas correctamente");

		Response<EventoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public EventoDTO getById(@PathVariable UUID id) {
		return EventoDTO.create().setIdentificador(id);
	}

	@PostMapping
	public ResponseEntity<Response<EventoDTO>> create(@RequestBody EventoDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EventoDTO>();

		try {
			var result = CrearEventoValidation.validate(dto);

			if (result.getMessages().isEmpty()) {
				facade = new EventoFacadeImpl();
				facade.register(dto);
				response.getMessages().add("El evento se ha creado correctamente");
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

	@PutMapping("/{id}")
	public ResponseEntity<Response<EventoDTO>> update(@PathVariable UUID id, @RequestBody EventoDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EventoDTO>();

		try {
			dto.setIdentificador(id);

			var result = ActualizarEventoValidation.validate(dto);

			if (result.getMessages().isEmpty()) {
				facade.modify(dto);
				response.getMessages().add("La agenda se ha actualizado correctamente");
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

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable UUID id) {
		var statusCode = HttpStatus.OK;
		var response = new Response<String>();

		try {
			EventoDTO dto = new EventoDTO();
			dto.setIdentificador(id);
			facade.drop(dto);
			response.getMessages().add("La agenda se ha eliminado correctamente");
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
