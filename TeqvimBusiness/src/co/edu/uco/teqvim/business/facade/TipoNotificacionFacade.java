package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoNotificacionDTO;

public interface TipoNotificacionFacade {

	List<TipoNotificacionDTO> list(TipoNotificacionDTO dto);

}
