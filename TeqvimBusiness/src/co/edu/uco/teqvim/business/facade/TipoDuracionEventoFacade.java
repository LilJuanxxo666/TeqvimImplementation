package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoDuracionEventoDTO;

public interface TipoDuracionEventoFacade {

	void register(TipoDuracionEventoDTO dto);

	List<TipoDuracionEventoDTO> list(TipoDuracionEventoDTO dto);

}
