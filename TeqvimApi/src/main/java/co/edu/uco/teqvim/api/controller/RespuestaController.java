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
import co.edu.uco.teqvim.api.validator.respuesta.CrearRespuestaValidation;
import co.edu.uco.teqvim.business.facade.RespuestaFacade;
import co.edu.uco.teqvim.business.facade.impl.RespuestaFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.dto.RespuestaDTO;

@RestController
@RequestMapping("teqvim/api/v1/confirmacioncorreo")
public final class RespuestaController {

	private Logger log = LoggerFactory.getLogger(RespuestaController.class);
	private RespuestaFacade facade;

	@GetMapping("/dummy")
	public RespuestaDTO dummy() {
		return RespuestaDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<RespuestaDTO>> list(@RequestBody RespuestaDTO dto) {

		facade = new RespuestaFacadeImpl();
		List<RespuestaDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add("Respuesta correo consultadas correctamente");

		Response<RespuestaDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public RespuestaDTO getById(@PathVariable UUID id) {
		return RespuestaDTO.create().setIdentificador(id);
	}

	@PostMapping
	public ResponseEntity<Response<RespuestaDTO>> create(@RequestBody RespuestaDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<RespuestaDTO>();

		try {
			var result = CrearRespuestaValidation.validate(dto);

			if (result.getMessages().isEmpty()) {
				facade = new RespuestaFacadeImpl();
				facade.register(dto);
				response.getMessages().add("La respuesta se ha creado correctamente");
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
