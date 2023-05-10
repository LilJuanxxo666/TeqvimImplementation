package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.EstadoEventoDTO;

public interface EstadoEventoFacade {

	void register(EstadoEventoDTO dto);

	List<EstadoEventoDTO> list(EstadoEventoDTO dto);

}
