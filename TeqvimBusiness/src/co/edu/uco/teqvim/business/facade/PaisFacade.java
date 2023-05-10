package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.PaisDTO;

public interface PaisFacade {

	void register(PaisDTO dto);

	List<PaisDTO> list(PaisDTO dto);

}
