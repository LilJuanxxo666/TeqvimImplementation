package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.UnidadTiempoDomain;

public interface UnidadTiempoBusiness {

	void register(UnidadTiempoDomain domain);

	List<UnidadTiempoDomain> list(UnidadTiempoDomain domain);

}
