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
import co.edu.uco.teqvim.api.validator.estudiante.ActualizarEstudianteValidation;
import co.edu.uco.teqvim.api.validator.estudiante.CrearEstudianteValidation;
import co.edu.uco.teqvim.business.facade.EstudianteFacade;
import co.edu.uco.teqvim.business.facade.impl.EstudianteFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.dto.EstudianteDTO;

@RestController
@RequestMapping("teqvim/api/v1/estudiante")
public final class EstudianteController {

	private Logger log = LoggerFactory.getLogger(EstudianteController.class);
	private EstudianteFacade facade;

	@GetMapping("/dummy")
	public EstudianteDTO dummy() {
		return EstudianteDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<EstudianteDTO>> list(@RequestBody EstudianteDTO dto) {

		facade = new EstudianteFacadeImpl();
		List<EstudianteDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add("Estudiante consultados correctamente");

		Response<EstudianteDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<EstudianteDTO>> getById(@PathVariable UUID id) {
		facade = new EstudianteFacadeImpl();
		EstudianteDTO dto = EstudianteDTO.create().setIdentificador(id);
		List<EstudianteDTO> lista = facade.list(dto);
		
		List<String> messages = new ArrayList<>();
		messages.add("Estudiante consultado correctamente");
		
		Response<EstudianteDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Response<EstudianteDTO>> create(@RequestBody EstudianteDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EstudianteDTO>();

		try {
			var result = CrearEstudianteValidation.validate(dto);
			if (result.getMessages().isEmpty()) {
				facade = new EstudianteFacadeImpl();
				facade.register(dto);
				response.getMessages().add("El estudiante se ha creado correctamente");
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
	public ResponseEntity<Response<EstudianteDTO>> update(@PathVariable UUID id, @RequestBody EstudianteDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EstudianteDTO>();

		try {
			dto.setIdentificador(id);

			var result = ActualizarEstudianteValidation.validate(dto);

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
			EstudianteDTO dto = new EstudianteDTO();
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
