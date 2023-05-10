package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.RepeticionAssembler;
import co.edu.uco.teqvim.business.business.RepeticionBusiness;
import co.edu.uco.teqvim.business.domain.RepeticionDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.RepeticionEntity;

public final class RepeticionBusinessImpl implements RepeticionBusiness {

	private DAOFactory daoFactory;

	public RepeticionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final RepeticionDomain domain) {
		final RepeticionEntity entity = RepeticionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRepeticionDAO().create(entity);

	}

	@Override
	public List<RepeticionDomain> list(final RepeticionDomain domain) {
		final RepeticionEntity entity = RepeticionAssembler.getInstance().toEntityFromDomain(domain);

		List<RepeticionEntity> resultEntityList = daoFactory.getRepeticionDAO().read(entity);

		return RepeticionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final RepeticionDomain domain) {
		final RepeticionEntity entity = RepeticionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRepeticionDAO().update(entity);

	}

	@Override
	public void drop(final RepeticionDomain domain) {
		final RepeticionEntity entity = RepeticionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRepeticionDAO().delete(entity);

	}

}
