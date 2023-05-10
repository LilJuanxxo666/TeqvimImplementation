package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.MateriaDomain;

public interface MateriaBusiness {

	void register(MateriaDomain domain);

	List<MateriaDomain> list(MateriaDomain domain);

	void modify(MateriaDomain domain);

	void drop(MateriaDomain domain);

}
