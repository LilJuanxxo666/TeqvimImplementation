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
import co.edu.uco.teqvim.api.validator.materia.ActualizarMateriaValidation;
import co.edu.uco.teqvim.api.validator.materia.CrearMateriaValidation;
import co.edu.uco.teqvim.business.facade.MateriaFacade;
import co.edu.uco.teqvim.business.facade.impl.MateriaFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.MateriaControllerMessages;
import co.edu.uco.teqvim.dto.MateriaDTO;

@RestController
@RequestMapping("teqvim/api/v1/materia")
public final class MateriaController {

	private Logger log = LoggerFactory.getLogger(MateriaController.class);
	private MateriaFacade facade;

	@GetMapping("/dummy")
	public MateriaDTO dummy() {
		return MateriaDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<MateriaDTO>> list(@RequestBody MateriaDTO dto) {

		facade = new MateriaFacadeImpl();
		List<MateriaDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(MateriaControllerMessages.READ_ESTUDIANTE_RIGHT_MESSAGE);

		Response<MateriaDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<MateriaDTO>> getById(@PathVariable UUID id) {
		facade = new MateriaFacadeImpl();
		MateriaDTO dto = MateriaDTO.create().setIdentificador(id);
		List<MateriaDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(MateriaControllerMessages.READ_ESTUDIANTE_RIGHT_MESSAGE);

		Response<MateriaDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Response<MateriaDTO>> create(@RequestBody MateriaDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<MateriaDTO>();
		facade = new MateriaFacadeImpl();

		try {
			var result = CrearMateriaValidation.validate(dto);
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
	public ResponseEntity<Response<MateriaDTO>> update(@RequestBody MateriaDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<MateriaDTO>();
		facade = new MateriaFacadeImpl();
		try {
			var result = ActualizarMateriaValidation.validate(dto);
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
		facade = new MateriaFacadeImpl();

		try {
			MateriaDTO dto = new MateriaDTO();
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
