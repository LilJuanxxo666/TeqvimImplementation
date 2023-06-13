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
import co.edu.uco.teqvim.business.facade.TipoDocumentoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoDocumentoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.utils.Messages.ConsultedControllerMessage;
import co.edu.uco.teqvim.dto.TipoDocumentoDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipodocumento")
public final class TipoDocumentoController {
    @GetMapping("/dummy")
    public TipoDocumentoDTO dummy() {
        return TipoDocumentoDTO.create();
    }

	@GetMapping
	public ResponseEntity<Response<TipoDocumentoDTO>> list(@RequestBody TipoDocumentoDTO dto) {
		
		TipoDocumentoFacade facade = new TipoDocumentoFacadeImpl();
		List<TipoDocumentoDTO> lista = facade.list(dto);
		
		List<String> messages = new ArrayList<>();
		messages.add(ConsultedControllerMessage.TIPO_DOCUMENTO_CONSULTED);
		
		Response<TipoDocumentoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
}
