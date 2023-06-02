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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.teqvim.api.controller.response.Response;
import co.edu.uco.teqvim.api.validator.tipodocumento.CrearTipoDocumentoValidation;
import co.edu.uco.teqvim.business.facade.TipoDocumentoFacade;
import co.edu.uco.teqvim.business.facade.impl.TipoDocumentoFacadeImpl;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.dto.TipoDocumentoDTO;

@RestController
@RequestMapping("teqvim/api/v1/tipodocumento")
public final class TipoDocumentoController {
	
	private Logger log = LoggerFactory.getLogger(TipoDocumentoController.class);
    private TipoDocumentoFacade facade;


    @GetMapping("/dummy")
    public TipoDocumentoDTO dummy() {
        return TipoDocumentoDTO.create();
    }

	@GetMapping
	public ResponseEntity<Response<TipoDocumentoDTO>> list(@RequestBody TipoDocumentoDTO dto) {
		
		facade = new TipoDocumentoFacadeImpl();
		List<TipoDocumentoDTO> lista = facade.list(dto);
		
		List<String> messages = new ArrayList<>();
		messages.add("Tipos de documentos consultadas correctamente");
		
		Response<TipoDocumentoDTO> response = new Response<>(lista, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}


    @GetMapping("/{id}")
    public TipoDocumentoDTO getById(@PathVariable UUID id) {
        return TipoDocumentoDTO.create().setIdentificador(id);
    }

    @PostMapping
    public ResponseEntity<Response<TipoDocumentoDTO>> create(@RequestBody TipoDocumentoDTO dto) {
        var statusCode = HttpStatus.OK;
        var response = new Response<TipoDocumentoDTO>();

        try {
            var result = CrearTipoDocumentoValidation.validate(dto);

            if (result.getMessages().isEmpty()) {
            	facade = new TipoDocumentoFacadeImpl();
                facade.register(dto);
                response.getMessages().add("El tipo de documento se ha creado correctamente");
            } else {
                statusCode = HttpStatus.BAD_REQUEST;
                response.setMessages(result.getMessages());
            }

        } catch (final TeqvimException exception) {
            statusCode = HttpStatus.BAD_REQUEST;
            response.getMessages().add(exception.getUserMessage());
            log.error(exception.getType().toString().concat(exception.getTechnicalMessage()), exception);
            
            exception.printStackTrace();
        } catch (final Exception exception) {
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            response.getMessages().add("Se ha presentado un problema inesperado. Por favor, intenta de nuevo y si el problema persiste, contacta al administrador de la aplicación");
            log.error("Se ha presentado un problema inesperado. Por favor validar la consola de errores...");
            exception.printStackTrace();
        }

        return new ResponseEntity<>(response, statusCode);
    }
}
