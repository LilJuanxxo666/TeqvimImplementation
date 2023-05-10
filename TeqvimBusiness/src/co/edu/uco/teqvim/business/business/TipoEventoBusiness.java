package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.TipoEventoDomain;

public interface TipoEventoBusiness {

	void register(TipoEventoDomain domain);

	List<TipoEventoDomain> list(TipoEventoDomain domain);

}
