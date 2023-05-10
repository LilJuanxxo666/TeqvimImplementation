package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.NotaAssembler;
import co.edu.uco.teqvim.business.business.NotaBusiness;
import co.edu.uco.teqvim.business.domain.NotaDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.NotaEntity;

public final class NotaBusinessImpl implements NotaBusiness {

	private DAOFactory daoFactory;

	public NotaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final NotaDomain domain) {
		final NotaEntity entity = NotaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getNotaDAO().create(entity);

	}

	@Override
	public List<NotaDomain> list(final NotaDomain domain) {
		final NotaEntity entity = NotaAssembler.getInstance().toEntityFromDomain(domain);

		List<NotaEntity> resultEntityList = daoFactory.getNotaDAO().read(entity);

		return NotaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final NotaDomain domain) {
		final NotaEntity entity = NotaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getNotaDAO().update(entity);

	}

	@Override
	public void drop(final NotaDomain domain) {
		final NotaEntity entity = NotaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getNotaDAO().delete(entity);

	}

}
