package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.EstadoNotificacionDTO;

public interface EstadoNotificacionFacade {

	List<EstadoNotificacionDTO> list(EstadoNotificacionDTO dto);

}
