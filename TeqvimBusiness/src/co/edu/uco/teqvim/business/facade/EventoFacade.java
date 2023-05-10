package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.EventoDTO;

public interface EventoFacade {

	void register(EventoDTO dto);

	List<EventoDTO> list(EventoDTO dto);

	void modify(EventoDTO dto);

	void drop(EventoDTO dto);

}
