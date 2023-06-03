package co.edu.uco.teqvim.api.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.teqvim.api.controller.response.Response;
import co.edu.uco.teqvim.business.facade.TipoEventoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoEventoFacadeImpl;
import co.edu.uco.teqvim.dto.TipoEventoDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipoevento")
public final class TipoEventoController {

	private Logger log = LoggerFactory.getLogger(TipoEventoController.class);
	private TipoEventoFacade facade;

	@GetMapping("/dummy")
	public TipoEventoDTO dummy() {
		return TipoEventoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoEventoDTO>> list(@RequestBody TipoEventoDTO dto) {

		facade = new TipoEventoFacadeImpl();
		List<TipoEventoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add("Tipos de evento consultadas correctamente");

		Response<TipoEventoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public TipoEventoDTO getById(@PathVariable UUID id) {
		return TipoEventoDTO.create().setIdentificador(id);
	}
}
