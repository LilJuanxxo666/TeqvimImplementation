package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EstadoEstudianteAssembler;
import co.edu.uco.teqvim.business.business.EstadoEstudianteBusiness;
import co.edu.uco.teqvim.business.domain.EstadoEstudianteDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;

public final class EstadoEstudianteBusinessImpl implements EstadoEstudianteBusiness {

	private DAOFactory daoFactory;

	public EstadoEstudianteBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final EstadoEstudianteDomain domain) {
		final EstadoEstudianteEntity entity = EstadoEstudianteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoEstudianteDAO().create(entity);

	}

	@Override
	public List<EstadoEstudianteDomain> list(final EstadoEstudianteDomain domain) {
		final EstadoEstudianteEntity entity = EstadoEstudianteAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoEstudianteEntity> resultEntityList = daoFactory.getEstadoEstudianteDAO().read(entity);

		return EstadoEstudianteAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
