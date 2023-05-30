package co.edu.uco.teqvim.business.business;

import java.util.List;

import co.edu.uco.teqvim.business.domain.DiaSemanaDomain;

public interface DiaSemanaBusiness {
	
	void register(DiaSemanaDomain domain);

	List<DiaSemanaDomain> list(DiaSemanaDomain domain);

	void modify(DiaSemanaDomain domain);

	void drop(DiaSemanaDomain domain);

}
