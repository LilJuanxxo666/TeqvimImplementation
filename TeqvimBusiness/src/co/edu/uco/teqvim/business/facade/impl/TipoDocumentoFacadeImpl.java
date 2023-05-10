package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoDocumentoDTO;

public final class TipoDocumentoFacadeImpl {

	void register(TipoDocumentoDTO dto);

	List<TipoDocumentoDTO> list(TipoDocumentoDTO dto);
}
