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
import co.edu.uco.teqvim.business.facade.TipoEventoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoEventoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.TipoEventoDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipoevento")
public final class TipoEventoController {
	@GetMapping("/dummy")
	public TipoEventoDTO dummy() {
		return TipoEventoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoEventoDTO>> list(@RequestBody TipoEventoDTO dto) {

		TipoEventoFacade facade = new TipoEventoFacadeImpl();
		List<TipoEventoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.TIPO_EVENTO_CONSULTED);

		Response<TipoEventoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
