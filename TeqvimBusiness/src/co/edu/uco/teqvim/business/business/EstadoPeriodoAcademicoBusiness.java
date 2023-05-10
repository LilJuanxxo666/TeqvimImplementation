package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.EstadoPeriodoAcademicoDomain;

public interface EstadoPeriodoAcademicoBusiness {

	void register(EstadoPeriodoAcademicoDomain domain);

	List<EstadoPeriodoAcademicoDomain> list(EstadoPeriodoAcademicoDomain domain);

}
