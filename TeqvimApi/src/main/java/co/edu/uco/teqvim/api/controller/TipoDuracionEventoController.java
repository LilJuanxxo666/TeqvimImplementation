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
import co.edu.uco.teqvim.business.facade.TipoDuracionEventoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoDuracionEventoFacadeImpl;
import co.edu.uco.teqvim.dto.TipoDuracionEventoDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipoduracionevento")
public final class TipoDuracionEventoController {

	private Logger log = LoggerFactory.getLogger(TipoDuracionEventoController.class);
	private TipoDuracionEventoFacade facade;

	@GetMapping("/dummy")
	public TipoDuracionEventoDTO dummy() {
		return TipoDuracionEventoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoDuracionEventoDTO>> list(@RequestBody TipoDuracionEventoDTO dto) {

		facade = new TipoDuracionEventoFacadeImpl();
		List<TipoDuracionEventoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add("Tipos de duracion de eventos consultados correctamente");

		Response<TipoDuracionEventoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public TipoDuracionEventoDTO getById(@PathVariable UUID id) {
		return TipoDuracionEventoDTO.create().setIdentificador(id);
	}
}
