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
import co.edu.uco.teqvim.business.facade.TipoNotificacionFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoNotificacionFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.TipoNotificacionDTO;

@RestController
@RequestMapping("teqvim/api/v1/tiponotificacion")
public final class TipoNotificacionController {
	@GetMapping("/dummy")
	public TipoNotificacionDTO dummy() {
		return TipoNotificacionDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoNotificacionDTO>> list(@RequestBody TipoNotificacionDTO dto) {
		TipoNotificacionFacade facade = new TipoNotificacionFacadeImpl();
		List<TipoNotificacionDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.TIPO_NOTIFICACION_CONSULTED);

		Response<TipoNotificacionDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
