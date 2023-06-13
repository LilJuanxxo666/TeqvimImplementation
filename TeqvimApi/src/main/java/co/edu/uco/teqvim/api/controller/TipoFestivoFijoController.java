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
import co.edu.uco.teqvim.business.facade.TipoFestivoFijoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoFestivoFijoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.TipoFestivoFijoDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipofestivofijo")
public class TipoFestivoFijoController {
	@GetMapping("/dummy")
	public TipoFestivoFijoDTO dummy() {
		return TipoFestivoFijoDTO.create();
	}

	@GetMapping
	public ResponseEntity<Response<TipoFestivoFijoDTO>> list(@RequestBody TipoFestivoFijoDTO dto) {
		TipoFestivoFijoFacade facade = new TipoFestivoFijoFacadeImpl();
		List<TipoFestivoFijoDTO> lista = facade.list(dto);

		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.TIPO_FESTIVO_FIJO_CONSULTED);

		Response<TipoFestivoFijoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
