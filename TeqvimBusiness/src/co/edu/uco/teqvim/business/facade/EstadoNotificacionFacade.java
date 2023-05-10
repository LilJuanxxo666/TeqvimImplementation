package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.EstadoNotificacionDTO;

public interface EstadoNotificacionFacade {

	void register(EstadoNotificacionDTO dto);

	List<EstadoNotificacionDTO> list(EstadoNotificacionDTO dto);

}
