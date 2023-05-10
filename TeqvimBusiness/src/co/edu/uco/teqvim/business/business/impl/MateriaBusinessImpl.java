package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.MateriaAssembler;
import co.edu.uco.teqvim.business.business.MateriaBusiness;
import co.edu.uco.teqvim.business.domain.MateriaDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.MateriaEntity;

public final class MateriaBusinessImpl implements MateriaBusiness {

	private DAOFactory daoFactory;

	public MateriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final MateriaDomain domain) {
		final MateriaEntity entity = MateriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getMateriaDAO().create(entity);

	}

	@Override
	public List<MateriaDomain> list(final MateriaDomain domain) {
		final MateriaEntity entity = MateriaAssembler.getInstance().toEntityFromDomain(domain);

		List<MateriaEntity> resultEntityList = daoFactory.getMateriaDAO().read(entity);

		return MateriaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final MateriaDomain domain) {
		final MateriaEntity entity = MateriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getMateriaDAO().update(entity);

	}

	@Override
	public void drop(final MateriaDomain domain) {
		final MateriaEntity entity = MateriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getMateriaDAO().delete(entity);

	}

}
