package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.TipoNotificacionDomain;

public interface TipoNotificacionBusiness {

	void register(TipoNotificacionDomain domain);

	List<TipoNotificacionDomain> list(TipoNotificacionDomain domain);

}
