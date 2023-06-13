package co.edu.uco.teqvim.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.teqvim.api.controller.response.Response;
import co.edu.uco.teqvim.business.facade.RespuestaFacade;
import co.edu.uco.teqvim.business.facade.impl.RespuestaFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.RespuestaDTO;

@RestController
@RequestMapping("teqvim/api/v1/respuesta")
public final class RespuestaController {
	@GetMapping("/dummy")
	public RespuestaDTO dummy() {
		return RespuestaDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<RespuestaDTO>> list(@RequestBody RespuestaDTO dto) {

		RespuestaFacade facade = new RespuestaFacadeImpl();
		List<RespuestaDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.RESPUESTA_CONSULTED);

		Response<RespuestaDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
