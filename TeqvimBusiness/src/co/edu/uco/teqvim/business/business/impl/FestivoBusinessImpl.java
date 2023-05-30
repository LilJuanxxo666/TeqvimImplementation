package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.FestivoAssembler;
import co.edu.uco.teqvim.business.business.FestivoBusiness;
import co.edu.uco.teqvim.business.domain.FestivoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.FestivoEntity;

public final class FestivoBusinessImpl implements FestivoBusiness {

	private DAOFactory daoFactory;

	public FestivoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<FestivoDomain> list(final FestivoDomain domain) {
		final FestivoEntity entity = FestivoAssembler.getInstance().toEntityFromDomain(domain);

		List<FestivoEntity> resultEntityList = daoFactory.getFestivoDAO().read(entity);

		return FestivoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
