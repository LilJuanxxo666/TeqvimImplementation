package co.edu.uco.teqvim.business.business;

import java.util.List;
import co.edu.uco.teqvim.business.domain.TipoDocumentoDomain;

public interface TipoDocumentoBusiness {

	void register(TipoDocumentoDomain domain);

	List<TipoDocumentoDomain> list(TipoDocumentoDomain domain);
}
