package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.FestivoDTO;

public interface FestivoFacade {

	List<FestivoDTO> list(FestivoDTO dto);
	
}
