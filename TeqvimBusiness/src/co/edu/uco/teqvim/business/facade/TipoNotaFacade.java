package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoNotaDTO;

public interface TipoNotaFacade {

	void register(TipoNotaDTO dto);

	List<TipoNotaDTO> list(TipoNotaDTO dto);

}
