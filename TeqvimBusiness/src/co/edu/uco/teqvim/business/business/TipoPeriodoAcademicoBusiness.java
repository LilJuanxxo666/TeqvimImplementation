package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.TipoPeriodoAcademicoDomain;

public interface TipoPeriodoAcademicoBusiness {

	void register(TipoPeriodoAcademicoDomain domain);

	List<TipoPeriodoAcademicoDomain> list(TipoPeriodoAcademicoDomain domain);

}
