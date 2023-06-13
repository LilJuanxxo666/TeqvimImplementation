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
import co.edu.uco.teqvim.business.facade.EstadoNotificacionFacade;
import co.edu.uco.teqvim.business.facade.impl.EstadoNotificacionFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.EstadoNotificacionDTO;

@RestController
@RequestMapping("teqvim/api/v1/estadonotificacion")
public final class EstadoNotificacionController {
	@GetMapping("/dummy")
	public EstadoNotificacionDTO dummy() {
		return EstadoNotificacionDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<EstadoNotificacionDTO>> list(@RequestBody EstadoNotificacionDTO dto) {
		EstadoNotificacionFacade facade = new EstadoNotificacionFacadeImpl();
		List<EstadoNotificacionDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.ESTADO_NOTIFICACION_CONSULTED);

		Response<EstadoNotificacionDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
