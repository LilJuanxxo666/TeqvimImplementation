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
import co.edu.uco.teqvim.api.validator.nota.ActualizarNotaValidation;
import co.edu.uco.teqvim.api.validator.nota.CrearNotaValidation;
import co.edu.uco.teqvim.business.facade.NotaFacade;
import co.edu.uco.teqvim.business.facade.impl.NotaFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.MateriaControllerMessages;
import co.edu.uco.teqvim.dto.MateriaDTO;
import co.edu.uco.teqvim.dto.NotaDTO;


@RestController
@RequestMapping("teqvim/api/v1/nota")
public final class NotaController {
	private Logger log = LoggerFactory.getLogger(NotaController.class);
	private NotaFacade facade;

	@GetMapping("/dummy")
	public NotaDTO dummy() {
		return NotaDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<NotaDTO>> list(@RequestBody NotaDTO dto) {

		facade = new NotaFacadeImpl();
		List<NotaDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(MateriaControllerMessages.READ_ESTUDIANTE_RIGHT_MESSAGE);

		Response<NotaDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<NotaDTO>> getById(@PathVariable UUID id) {
		facade = new NotaFacadeImpl();
		NotaDTO dto = NotaDTO.create().setIdentificador(id);
		List<NotaDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(MateriaControllerMessages.READ_ESTUDIANTE_RIGHT_MESSAGE);

		Response<NotaDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Response<NotaDTO>> create(@RequestBody NotaDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<NotaDTO>();
		facade = new NotaFacadeImpl();

		try {
			var result = CrearNotaValidation.validate(dto);
			if (result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages().add(MateriaControllerMessages.CREATE_ESTUDIANTE_RIGHT_MESSAGE);
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
			response.getMessages().add(MateriaControllerMessages.UNEXPECTED_PROBLEM_MESSAGE);
			log.error(MateriaControllerMessages.UNEXPECTED_PROBLEM_CREATE_LOG_MESSAGE);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(response, statusCode);
	}

	@PutMapping
	public ResponseEntity<Response<NotaDTO>> update(@RequestBody NotaDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<NotaDTO>();
		facade = new NotaFacadeImpl();
		try {
			var result = ActualizarNotaValidation.validate(dto);
			if (result.getMessages().isEmpty()) {
				facade.modify(dto);
				response.getMessages().add(MateriaControllerMessages.DELETE_ESTUDIANTE_RIGHT_MESSAGE);
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
			response.getMessages().add(MateriaControllerMessages.UNEXPECTED_PROBLEM_MESSAGE);
			log.error(MateriaControllerMessages.UNEXPECTED_PROBLEM_UPDATE_LOG_MESSAGE);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(response, statusCode);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable UUID id) {
		var statusCode = HttpStatus.OK;
		var response = new Response<String>();
		facade = new NotaFacadeImpl();

		try {
			NotaDTO dto = new NotaDTO();
			dto.setIdentificador(id);
			facade.drop(dto);
			response.getMessages().add(MateriaControllerMessages.DELETE_ESTUDIANTE_RIGHT_MESSAGE);
		} catch (final TeqvimException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat(exception.getTechnicalMessage()), exception);

			exception.printStackTrace();
		} catch (final Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add(MateriaControllerMessages.UNEXPECTED_PROBLEM_MESSAGE);
			log.error(MateriaControllerMessages.UNEXPECTED_PROBLEM_DELETE_LOG_MESSAGE);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(response, statusCode);
	}
}
