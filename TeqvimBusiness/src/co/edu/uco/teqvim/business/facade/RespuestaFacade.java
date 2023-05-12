package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.RespuestaDTO;

public interface RespuestaFacade {

	List<RespuestaDTO> list(RespuestaDTO dto);

}
