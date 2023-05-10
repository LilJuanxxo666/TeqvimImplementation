package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EstudianteAssembler;
import co.edu.uco.teqvim.business.business.EstudianteBusiness;
import co.edu.uco.teqvim.business.domain.EstudianteDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.EstudianteEntity;

public final class EstudianteBusinessImpl implements EstudianteBusiness {

	private DAOFactory daoFactory;

	public EstudianteBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final EstudianteDomain domain) {
		final EstudianteEntity entity = EstudianteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstudianteDAO().create(entity);

	}

	@Override
	public List<EstudianteDomain> list(final EstudianteDomain domain) {
		final EstudianteEntity entity = EstudianteAssembler.getInstance().toEntityFromDomain(domain);

		List<EstudianteEntity> resultEntityList = daoFactory.getEstudianteDAO().read(entity);

		return EstudianteAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final EstudianteDomain domain) {
		final EstudianteEntity entity = EstudianteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstudianteDAO().update(entity);

	}

	@Override
	public void drop(final EstudianteDomain domain) {
		final EstudianteEntity entity = EstudianteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstudianteDAO().delete(entity);

	}

}
