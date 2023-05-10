package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.UnidadTiempoDTO;

public interface UnidadTiempoFacade {

	void register(UnidadTiempoDTO dto);

	List<UnidadTiempoDTO> list(UnidadTiempoDTO dto);

}
