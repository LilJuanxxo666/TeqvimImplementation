package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.TipoNotaDomain;

public interface TipoNotaBusiness {

	void register(TipoNotaDomain domain);

	List<TipoNotaDomain> list(TipoNotaDomain domain);

}
