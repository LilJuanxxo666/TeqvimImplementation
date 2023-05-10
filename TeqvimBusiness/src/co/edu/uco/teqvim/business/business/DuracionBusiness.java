package co.edu.uco.teqvim.business.business;

import java.util.List;

import co.edu.uco.teqvim.business.domain.DuracionDomain;

public interface DuracionBusiness {

	void register(DuracionDomain domain);

	List<DuracionDomain> list(DuracionDomain domain);

	void modify(DuracionDomain domain);

	void drop(DuracionDomain domain);

}
