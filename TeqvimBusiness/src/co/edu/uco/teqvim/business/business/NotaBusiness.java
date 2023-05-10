package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.NotaDomain;

public interface NotaBusiness {

	void register(NotaDomain domain);

	List<NotaDomain> list(NotaDomain domain);

	void modify(NotaDomain domain);

	void drop(NotaDomain domain);

}
