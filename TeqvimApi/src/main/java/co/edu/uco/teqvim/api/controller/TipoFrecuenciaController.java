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
import co.edu.uco.teqvim.business.facade.TipoFrecuenciaFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoFrecuenciaFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.TipoFrecuenciaDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipofrecuencia")
public final class TipoFrecuenciaController {
	@GetMapping("/dummy")
	public TipoFrecuenciaDTO dummy() {
		return TipoFrecuenciaDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoFrecuenciaDTO>> list(@RequestBody TipoFrecuenciaDTO dto) {
		TipoFrecuenciaFacade facade = new TipoFrecuenciaFacadeImpl();
		List<TipoFrecuenciaDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.TIPO_FRECUENCIA_CONSULTED);

		Response<TipoFrecuenciaDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
