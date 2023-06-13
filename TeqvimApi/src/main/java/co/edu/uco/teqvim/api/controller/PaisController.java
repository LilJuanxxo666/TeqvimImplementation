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
import co.edu.uco.teqvim.business.facade.PaisFacade;
import co.edu.uco.teqvim.business.facade.impl.PaisFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.PaisDTO;

@RestController
@RequestMapping("teqvim/api/v1/pais")
public final class PaisController {
	
	@GetMapping("/dummy")
	public PaisDTO dummy() {
		return PaisDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<PaisDTO>> list(@RequestBody PaisDTO dto) {
		PaisFacade facade = new PaisFacadeImpl();
		List<PaisDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.PAIS_CONSULTED);

		Response<PaisDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
