package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.DuracionAssembler;
import co.edu.uco.teqvim.business.business.DuracionBusiness;
import co.edu.uco.teqvim.business.domain.DuracionDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.DuracionEntity;

public final class DuracionBusinessImpl implements DuracionBusiness {

	private DAOFactory daoFactory;

	public DuracionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final DuracionDomain domain) {
		final DuracionEntity entity = DuracionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getDuracionDAO().create(entity);

	}

	@Override
	public List<DuracionDomain> list(final DuracionDomain domain) {
		final DuracionEntity entity = DuracionAssembler.getInstance().toEntityFromDomain(domain);

		List<DuracionEntity> resultEntityList = daoFactory.getDuracionDAO().read(entity);

		return DuracionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final DuracionDomain domain) {
		final DuracionEntity entity = DuracionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getDuracionDAO().update(entity);

	}

	@Override
	public void drop(final DuracionDomain domain) {
		final DuracionEntity entity = DuracionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getDuracionDAO().delete(entity);

	}

}
