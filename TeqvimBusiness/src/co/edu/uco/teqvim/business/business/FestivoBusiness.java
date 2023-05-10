package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.FestivoDomain;

public interface FestivoBusiness {

	void register(FestivoDomain domain);

	List<FestivoDomain> list(FestivoDomain domain);

	void modify(FestivoDomain domain);

	void drop(FestivoDomain domain);

}
