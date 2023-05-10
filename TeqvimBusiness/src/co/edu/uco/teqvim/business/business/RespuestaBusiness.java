package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.RespuestaDomain;

public interface RespuestaBusiness {

	void register(RespuestaDomain domain);

	List<RespuestaDomain> list(RespuestaDomain domain);

}
