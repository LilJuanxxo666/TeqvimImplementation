package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.TipoFestivoFijoDomain;

public interface TipoFestivoFijoBusiness {

	void register(TipoFestivoFijoDomain domain);

	List<TipoFestivoFijoDomain> list(TipoFestivoFijoDomain domain);

}
