package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoEventoDTO;

public interface TipoEventoFacade {

	void register(TipoEventoDTO dto);

	List<TipoEventoDTO> list(TipoEventoDTO dto);

}
