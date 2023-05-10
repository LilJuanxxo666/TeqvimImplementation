package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoFestivoDTO;

public interface TipoFestivoFacade {

	void register(TipoFestivoDTO dto);

	List<TipoFestivoDTO> list(TipoFestivoDTO dto);

}
