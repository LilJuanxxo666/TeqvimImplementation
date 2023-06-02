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
import co.edu.uco.teqvim.api.validator.pais.CrearPaisValidation;
import co.edu.uco.teqvim.business.facade.PaisFacade;
import co.edu.uco.teqvim.business.facade.impl.PaisFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.dto.PaisDTO;

@RestController
@RequestMapping("teqvim/api/v1/pais")
public final class PaisController {

	private Logger log = LoggerFactory.getLogger(PaisController.class);
	private PaisFacade facade;

	@GetMapping("/dummy")
	public PaisDTO dummy() {
		return PaisDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<PaisDTO>> list(@RequestBody PaisDTO dto) {

		facade = new PaisFacadeImpl();
		List<PaisDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add("Paises consultados correctamente");

		Response<PaisDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public PaisDTO getById(@PathVariable UUID id) {
		return PaisDTO.create().setIdentificador(id);
	}

	@PostMapping
	public ResponseEntity<Response<PaisDTO>> create(@RequestBody PaisDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<PaisDTO>();

		try {
			var result = CrearPaisValidation.validate(dto);

			if (result.getMessages().isEmpty()) {
				facade = new PaisFacadeImpl();
				facade.register(dto);
				response.getMessages().add("El pais se ha creado correctamente");
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
