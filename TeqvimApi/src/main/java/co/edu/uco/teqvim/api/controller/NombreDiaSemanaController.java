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
import co.edu.uco.teqvim.business.facade.NombreDiaSemanaFacade;
import co.edu.uco.teqvim.business.facade.impl.NombreDiaSemanaFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.NombreDiaSemanaDTO;

@RestController
@RequestMapping("teqvim/api/v1/nombrediasemana")
public final class NombreDiaSemanaController {
	@GetMapping("/dummy")
	public NombreDiaSemanaDTO dummy() {
		return NombreDiaSemanaDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<NombreDiaSemanaDTO>> list(@RequestBody NombreDiaSemanaDTO dto) {

		NombreDiaSemanaFacade facade = new NombreDiaSemanaFacadeImpl();
		List<NombreDiaSemanaDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.NOMBRE_DIA_SEMANA_CONSULTED);

		Response<NombreDiaSemanaDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
