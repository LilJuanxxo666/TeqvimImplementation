package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;
import co.edu.uco.teqvim.dto.EventoDTO;

public final class EventoFacadeImpl {

	void register(EventoDTO dto);

	List<EventoDTO> list(EventoDTO dto);

	void modify(EventoDTO dto);

	void drop(EventoDTO dto);

}
