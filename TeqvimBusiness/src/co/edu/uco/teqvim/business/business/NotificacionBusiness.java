package co.edu.uco.teqvim.business.business;

import java.util.List;

import co.edu.uco.teqvim.business.domain.NotificacionDomain;

public interface NotificacionBusiness {

	void register(NotificacionDomain domain);

	List<NotificacionDomain> list(NotificacionDomain domain);

	void modify(NotificacionDomain domain);

	void drop(NotificacionDomain domain);

}
