package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.FrecuenciaAssembler;
import co.edu.uco.teqvim.business.business.FrecuenciaBusiness;
import co.edu.uco.teqvim.business.domain.FrecuenciaDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.FrecuenciaEntity;

public final class FrecuenciaBusinessImpl implements FrecuenciaBusiness {

	private DAOFactory daoFactory;

	public FrecuenciaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final FrecuenciaDomain domain) {
		final FrecuenciaEntity entity = FrecuenciaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getFrecuenciaDAO().create(entity);

	}

	@Override
	public List<FrecuenciaDomain> list(final FrecuenciaDomain domain) {
		final FrecuenciaEntity entity = FrecuenciaAssembler.getInstance().toEntityFromDomain(domain);

		List<FrecuenciaEntity> resultEntityList = daoFactory.getFrecuenciaDAO().read(entity);

		return FrecuenciaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final FrecuenciaDomain domain) {
		final FrecuenciaEntity entity = FrecuenciaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getFrecuenciaDAO().update(entity);

	}

	@Override
	public void drop(final FrecuenciaDomain domain) {
		final FrecuenciaEntity entity = FrecuenciaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getFrecuenciaDAO().delete(entity);

	}

}
