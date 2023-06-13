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
import co.edu.uco.teqvim.business.facade.UnidadTiempoFacade;
import co.edu.uco.teqvim.business.facade.impl.UnidadTiempoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.UnidadTiempoDTO;


@RestController
@RequestMapping("teqvim/api/v1/unidadtiempo")
public final class UnidadTiempoController {
	
	@GetMapping("/dummy")
	public UnidadTiempoDTO dummy() {
		return UnidadTiempoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<UnidadTiempoDTO>> list(@RequestBody UnidadTiempoDTO dto) {
		UnidadTiempoFacade facade = new UnidadTiempoFacadeImpl();
		List<UnidadTiempoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.UNIDAD_TIEMPO_CONSULTED);

		Response<UnidadTiempoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
