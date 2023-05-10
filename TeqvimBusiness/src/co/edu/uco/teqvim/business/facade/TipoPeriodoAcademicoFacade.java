package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.TipoPeriodoAcademicoDTO;

public interface TipoPeriodoAcademicoFacade {

	void register(TipoPeriodoAcademicoDTO dto);

	List<TipoPeriodoAcademicoDTO> list(TipoPeriodoAcademicoDTO dto);

}
