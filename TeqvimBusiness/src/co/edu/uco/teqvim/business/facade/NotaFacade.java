package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.NotaDTO;

public interface NotaFacade {

	void register(NotaDTO dto);

	List<NotaDTO> list(NotaDTO dto);

	void modify(NotaDTO dto);

	void drop(NotaDTO dto);

}
