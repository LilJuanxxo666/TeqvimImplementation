package co.edu.uco.teqvim.business.facade;

import java.util.List;

import co.edu.uco.teqvim.dto.NotificacionDTO;

public interface NotificacionFacade {

	void register(NotificacionDTO dto);

	List<NotificacionDTO> list(NotificacionDTO dto);

	void modify(NotificacionDTO dto);

	void drop(NotificacionDTO dto);

}
