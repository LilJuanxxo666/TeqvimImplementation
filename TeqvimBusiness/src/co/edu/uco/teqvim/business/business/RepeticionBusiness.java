package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.RepeticionDomain;

public interface RepeticionBusiness {

	void register(RepeticionDomain domain);

	List<RepeticionDomain> list(RepeticionDomain domain);

	void modify(RepeticionDomain domain);

	void drop(RepeticionDomain domain);

}
