package co.edu.uco.teqvim.business.business;

import java.util.List;

import co.edu.uco.teqvim.business.domain.EstadoEstudianteDomain;

public interface EstadoEstudianteBusiness {

	void register(EstadoEstudianteDomain domain);

	List<EstadoEstudianteDomain> list(EstadoEstudianteDomain domain);

}
