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
import co.edu.uco.teqvim.business.facade.TipoNotaFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoNotaFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.TipoNotaDTO;


@RestController
@RequestMapping("teqvim/api/v1/tiponota")
public final class TipoNotaController {
	@GetMapping("/dummy")
	public TipoNotaDTO dummy() {
		return TipoNotaDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoNotaDTO>> list(@RequestBody TipoNotaDTO dto) {
		TipoNotaFacade facade = new TipoNotaFacadeImpl();
		List<TipoNotaDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.TIPO_NOTA_CONSULTED);

		Response<TipoNotaDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
