package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;
import co.edu.uco.teqvim.dto.PeriodoAcademicoDTO;

public final class PeriodoAcademicoFacadeImpl {

	void register(PeriodoAcademicoDTO dto);

	List<PeriodoAcademicoDTO> list(PeriodoAcademicoDTO dto);

	void modify(PeriodoAcademicoDTO dto);

	void drop(PeriodoAcademicoDTO dto);

}
