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
import co.edu.uco.teqvim.business.facade.EstadoEstudianteFacade;
import co.edu.uco.teqvim.business.facade.impl.EstadoEstudianteFacadeImpl;
import co.edu.uco.teqvim.dto.EstadoEstudianteDTO;

@RestController
@RequestMapping("teqvim/api/v1/estadoestudiante")
public final class EstadoEstudianteController {

	private Logger log = LoggerFactory.getLogger(EstadoEstudianteController.class);
	private EstadoEstudianteFacade facade;

	@GetMapping("/dummy")
	public EstadoEstudianteDTO dummy() {
		return EstadoEstudianteDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<EstadoEstudianteDTO>> list(@RequestBody EstadoEstudianteDTO dto) {

		facade = new EstadoEstudianteFacadeImpl();
		List<EstadoEstudianteDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add("Estado estudiante consultadas correctamente");

		Response<EstadoEstudianteDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public EstadoEstudianteDTO getById(@PathVariable UUID id) {
		return EstadoEstudianteDTO.create().setIdentificador(id);
	}
}
