package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.EstadoEventoDomain;

public interface EstadoEventoBusiness {

	void register(EstadoEventoDomain domain);

	List<EstadoEventoDomain> list(EstadoEventoDomain domain);

}
