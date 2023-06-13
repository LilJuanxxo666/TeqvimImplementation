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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.teqvim.api.controller.response.Response;
import co.edu.uco.teqvim.business.facade.EstadoEventoFacade;
import co.edu.uco.teqvim.business.facade.impl.EstadoEventoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.EstadoEventoDTO;

@RestController
@RequestMapping("teqvim/api/v1/estadoevento")
public final class EstadoEventoController {
	@GetMapping("/dummy")
	public EstadoEventoDTO dummy() {
		return EstadoEventoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<EstadoEventoDTO>> list(@RequestBody EstadoEventoDTO dto) {

		EstadoEventoFacade facade = new EstadoEventoFacadeImpl();
		List<EstadoEventoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.ESTADO_EVENTO_CONSULTED);

		Response<EstadoEventoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
