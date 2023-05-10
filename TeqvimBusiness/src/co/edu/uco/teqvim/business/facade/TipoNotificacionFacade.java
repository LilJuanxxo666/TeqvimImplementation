package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoNotificacionDTO;

public interface TipoNotificacionFacade {

	void register(TipoNotificacionDTO dto);

	List<TipoNotificacionDTO> list(TipoNotificacionDTO dto);

}
