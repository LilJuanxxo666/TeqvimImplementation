package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.EstudianteDomain;

public interface EstudianteBusiness {

	void register(EstudianteDomain domain);

	List<EstudianteDomain> list(EstudianteDomain domain);

	void modify(EstudianteDomain domain);

	void drop(EstudianteDomain domain);

}
