package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.FrecuenciaDomain;

public interface FrecuenciaBusiness {

	void register(FrecuenciaDomain domain);

	List<FrecuenciaDomain> list(FrecuenciaDomain domain);

	void modify(FrecuenciaDomain domain);

	void drop(FrecuenciaDomain domain);

}
