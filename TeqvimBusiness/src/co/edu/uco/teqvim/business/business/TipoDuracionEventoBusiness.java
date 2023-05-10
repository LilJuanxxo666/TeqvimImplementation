package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.TipoDuracionEventoDomain;

public interface TipoDuracionEventoBusiness {

	void register(TipoDuracionEventoDomain domain);

	List<TipoDuracionEventoDomain> list(TipoDuracionEventoDomain domain);

}
