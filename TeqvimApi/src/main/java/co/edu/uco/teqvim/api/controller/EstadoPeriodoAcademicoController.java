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
import co.edu.uco.teqvim.business.facade.EstadoPeriodoAcademicoFacade;
import co.edu.uco.teqvim.business.facade.impl.EstadoPeriodoAcademicoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.EstadoPeriodoAcademicoDTO;

@RestController
@RequestMapping("teqvim/api/v1/estadoperiodoacademico")
public final class EstadoPeriodoAcademicoController {
	@GetMapping("/dummy")
	public EstadoPeriodoAcademicoDTO dummy() {
		return EstadoPeriodoAcademicoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<EstadoPeriodoAcademicoDTO>> list(@RequestBody EstadoPeriodoAcademicoDTO dto) {
		EstadoPeriodoAcademicoFacade facade = new EstadoPeriodoAcademicoFacadeImpl();
		List<EstadoPeriodoAcademicoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.ESTADO_PERIODO_ACADEMICO_CONSULTED);

		Response<EstadoPeriodoAcademicoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
}
