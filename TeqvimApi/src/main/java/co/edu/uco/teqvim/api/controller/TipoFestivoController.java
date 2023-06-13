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
import co.edu.uco.teqvim.business.facade.TipoFestivoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoFestivoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.TipoFestivoDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipofestivo")
public final class TipoFestivoController {
	@GetMapping("/dummy")
	public TipoFestivoDTO dummy() {
		return TipoFestivoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoFestivoDTO>> list(@RequestBody TipoFestivoDTO dto) {
		TipoFestivoFacade facade = new TipoFestivoFacadeImpl();
		List<TipoFestivoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.TIPO_FESTIVO_CONSULTED);

		Response<TipoFestivoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
