package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.TipoEventoDomain;

public interface TipoEventoBusiness {

	List<TipoEventoDomain> list(TipoEventoDomain domain);

}
