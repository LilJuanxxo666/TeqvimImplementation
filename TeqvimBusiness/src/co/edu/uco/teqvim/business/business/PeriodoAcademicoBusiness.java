package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.PeriodoAcademicoDomain;

public interface PeriodoAcademicoBusiness {

	void register(PeriodoAcademicoDomain domain);

	List<PeriodoAcademicoDomain> list(PeriodoAcademicoDomain domain);

	void modify(PeriodoAcademicoDomain domain);

	void drop(PeriodoAcademicoDomain domain);

}
