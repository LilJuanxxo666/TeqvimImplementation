package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoFestivoAssembler;
import co.edu.uco.teqvim.business.business.TipoFestivoBusiness;
import co.edu.uco.teqvim.business.domain.TipoFestivoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.TipoFestivoEntity;

public final class TipoFestivoBusinessImpl implements TipoFestivoBusiness {

	private DAOFactory daoFactory;

	public TipoFestivoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoFestivoDomain> list(final TipoFestivoDomain domain) {
		final TipoFestivoEntity entity = TipoFestivoAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoFestivoEntity> resultEntityList = daoFactory.getTipoFestivoDAO().read(entity);

		return TipoFestivoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
