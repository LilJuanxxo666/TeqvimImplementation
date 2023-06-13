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
import co.edu.uco.teqvim.business.facade.EstadoEstudianteFacade;
import co.edu.uco.teqvim.business.facade.impl.EstadoEstudianteFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.EstadoEstudianteDTO;

@RestController
@RequestMapping("teqvim/api/v1/estadoestudiante")
public final class EstadoEstudianteController {
	@GetMapping("/dummy")
	public EstadoEstudianteDTO dummy() {
		return EstadoEstudianteDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<EstadoEstudianteDTO>> list(@RequestBody EstadoEstudianteDTO dto) {

		EstadoEstudianteFacade facade = new EstadoEstudianteFacadeImpl();
		List<EstadoEstudianteDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.ESTADO_ESTUDIANTE_CONSULTED);

		Response<EstadoEstudianteDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
