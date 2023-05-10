package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.RespuestaDTO;

public interface RespuestaFacade {

	void register(RespuestaDTO dto);

	List<RespuestaDTO> list(RespuestaDTO dto);

}
