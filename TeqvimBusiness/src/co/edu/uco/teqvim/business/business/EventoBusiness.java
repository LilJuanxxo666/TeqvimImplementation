package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.EventoDomain;

public interface EventoBusiness {

	void register(EventoDomain domain);

	List<EventoDomain> list(EventoDomain domain);

	void modify(EventoDomain domain);

	void drop(EventoDomain domain);

}
