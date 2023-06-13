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
import co.edu.uco.teqvim.business.facade.TipoDuracionEventoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoDuracionEventoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.TipoDuracionEventoDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipoduracionevento")
public final class TipoDuracionEventoController {
	@GetMapping("/dummy")
	public TipoDuracionEventoDTO dummy() {
		return TipoDuracionEventoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoDuracionEventoDTO>> list(@RequestBody TipoDuracionEventoDTO dto) {

		TipoDuracionEventoFacade facade = new TipoDuracionEventoFacadeImpl();
		List<TipoDuracionEventoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.TIPO_DURACION_EVENTO_CONSULTED);

		Response<TipoDuracionEventoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
