package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.EstadoPeriodoAcademicoDTO;

public interface EstadoPeriodoAcademicoFacade {

	void register(EstadoPeriodoAcademicoDTO dto);

	List<EstadoPeriodoAcademicoDTO> list(EstadoPeriodoAcademicoDTO dto);

}
