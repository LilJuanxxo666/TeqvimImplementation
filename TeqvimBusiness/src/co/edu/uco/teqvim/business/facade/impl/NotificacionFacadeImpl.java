package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.dto.NotificacionDTO;

public final class NotificacionFacadeImpl {

	void register(NotificacionDTO dto);

	List<NotificacionDTO> list(NotificacionDTO dto);

	void modify(NotificacionDTO dto);

	void drop(NotificacionDTO dto);

}
