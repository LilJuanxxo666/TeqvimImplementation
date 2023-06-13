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
import co.edu.uco.teqvim.api.validator.periodoacademico.ActualizarPeriodoAcademicoValidation;
import co.edu.uco.teqvim.api.validator.periodoacademico.CrearPeriodoAcademicoValidation;
import co.edu.uco.teqvim.business.facade.PeriodoAcademicoFacade;
import co.edu.uco.teqvim.business.facade.impl.PeriodoAcademicoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.PeriodoAcademicoControllerMessages;
import co.edu.uco.teqvim.dto.PeriodoAcademicoDTO;

@RestController
@RequestMapping("teqvim/api/v1/periodoacademico")

public final class PeriodoAcademicoController {
	private Logger log = LoggerFactory.getLogger(PeriodoAcademicoController.class);
	private PeriodoAcademicoFacade facade;

	@GetMapping("/dummy")
	public PeriodoAcademicoDTO dummy() {
		return PeriodoAcademicoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<PeriodoAcademicoDTO>> list(@RequestBody PeriodoAcademicoDTO dto) {

		facade = new PeriodoAcademicoFacadeImpl();
		List<PeriodoAcademicoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(PeriodoAcademicoControllerMessages.READ_ESTUDIANTE_RIGHT_MESSAGE);

		Response<PeriodoAcademicoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<PeriodoAcademicoDTO>> getById(@PathVariable UUID id) {
		facade = new PeriodoAcademicoFacadeImpl();
		PeriodoAcademicoDTO dto = PeriodoAcademicoDTO.create().setIdentificador(id);
		List<PeriodoAcademicoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(PeriodoAcademicoControllerMessages.READ_ESTUDIANTE_RIGHT_MESSAGE);

		Response<PeriodoAcademicoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Response<PeriodoAcademicoDTO>> create(@RequestBody PeriodoAcademicoDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<PeriodoAcademicoDTO>();
		facade = new PeriodoAcademicoFacadeImpl();

		try {
			var result = CrearPeriodoAcademicoValidation.validate(dto);
			if (result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages().add(PeriodoAcademicoControllerMessages.CREATE_ESTUDIANTE_RIGHT_MESSAGE);
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
			response.getMessages().add(PeriodoAcademicoControllerMessages.UNEXPECTED_PROBLEM_MESSAGE);
			log.error(PeriodoAcademicoControllerMessages.UNEXPECTED_PROBLEM_CREATE_LOG_MESSAGE);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(response, statusCode);
	}

	@PutMapping
	public ResponseEntity<Response<PeriodoAcademicoDTO>> update(@RequestBody PeriodoAcademicoDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<PeriodoAcademicoDTO>();
		facade = new PeriodoAcademicoFacadeImpl();
		try {
			var result = ActualizarPeriodoAcademicoValidation.validate(dto);
			if (result.getMessages().isEmpty()) {
				facade.modify(dto);
				response.getMessages().add(PeriodoAcademicoControllerMessages.DELETE_ESTUDIANTE_RIGHT_MESSAGE);
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
			response.getMessages().add(PeriodoAcademicoControllerMessages.UNEXPECTED_PROBLEM_MESSAGE);
			log.error(PeriodoAcademicoControllerMessages.UNEXPECTED_PROBLEM_UPDATE_LOG_MESSAGE);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(response, statusCode);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable UUID id) {
		var statusCode = HttpStatus.OK;
		var response = new Response<String>();
		facade = new PeriodoAcademicoFacadeImpl();
		try {
			PeriodoAcademicoDTO dto = new PeriodoAcademicoDTO();
			dto.setIdentificador(id);
			facade.drop(dto);
			response.getMessages().add(PeriodoAcademicoControllerMessages.DELETE_ESTUDIANTE_RIGHT_MESSAGE);
		} catch (final TeqvimException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat(exception.getTechnicalMessage()), exception);

			exception.printStackTrace();
		} catch (final Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add(PeriodoAcademicoControllerMessages.UNEXPECTED_PROBLEM_MESSAGE);
			log.error(PeriodoAcademicoControllerMessages.UNEXPECTED_PROBLEM_DELETE_LOG_MESSAGE);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(response, statusCode);
	}
}
