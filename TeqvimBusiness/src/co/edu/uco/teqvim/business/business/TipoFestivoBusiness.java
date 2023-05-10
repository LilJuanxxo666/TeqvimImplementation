package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.TipoFestivoDomain;

public interface TipoFestivoBusiness {

	void register(TipoFestivoDomain domain);

	List<TipoFestivoDomain> list(TipoFestivoDomain domain);

}
