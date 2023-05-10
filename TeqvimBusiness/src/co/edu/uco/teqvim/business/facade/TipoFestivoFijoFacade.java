package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoFestivoFijoDTO;

public interface TipoFestivoFijoFacade {

	void register(TipoFestivoFijoDTO dto);

	List<TipoFestivoFijoDTO> list(TipoFestivoFijoDTO dto);

}
