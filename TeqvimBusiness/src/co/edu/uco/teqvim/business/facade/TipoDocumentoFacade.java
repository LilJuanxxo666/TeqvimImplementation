package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoDocumentoDTO;

public interface TipoDocumentoFacade {

	void register(TipoDocumentoDTO dto);

	List<TipoDocumentoDTO> list(TipoDocumentoDTO dto);
}
