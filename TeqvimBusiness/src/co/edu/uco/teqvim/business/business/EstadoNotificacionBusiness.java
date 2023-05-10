package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.EstadoNotificacionDomain;

public interface EstadoNotificacionBusiness {

	void register(EstadoNotificacionDomain domain);

	List<EstadoNotificacionDomain> list(EstadoNotificacionDomain domain);

}
