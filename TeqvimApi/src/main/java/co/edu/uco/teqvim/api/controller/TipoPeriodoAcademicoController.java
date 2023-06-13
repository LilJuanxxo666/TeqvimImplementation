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
import co.edu.uco.teqvim.business.facade.TipoPeriodoAcademicoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoPeriodoAcademicoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.TipoPeriodoAcademicoDTO;


@RestController
@RequestMapping("teqvim/api/v1/tipoperiodoacademico")
public final class TipoPeriodoAcademicoController {
	@GetMapping("/dummy")
	public TipoPeriodoAcademicoDTO dummy() {
		return TipoPeriodoAcademicoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoPeriodoAcademicoDTO>> list(@RequestBody TipoPeriodoAcademicoDTO dto) {
		TipoPeriodoAcademicoFacade facade = new TipoPeriodoAcademicoFacadeImpl();
		List<TipoPeriodoAcademicoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.TIPO_PERIODO_ACADEMICO_CONSULTED);

		Response<TipoPeriodoAcademicoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
