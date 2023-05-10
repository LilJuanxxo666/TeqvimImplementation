package co.edu.uco.teqvim.business.facade;

import java.util.List;

import co.edu.uco.teqvim.dto.DuracionDTO;

public interface DuracionFacade {

	void register(DuracionDTO dto);

	List<DuracionDTO> list(DuracionDTO dto);

	void modify(DuracionDTO dto);

	void drop(DuracionDTO dto);

}
