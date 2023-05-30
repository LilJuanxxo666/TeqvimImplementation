package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoNotaAssembler;
import co.edu.uco.teqvim.business.business.TipoNotaBusiness;
import co.edu.uco.teqvim.business.domain.TipoNotaDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.TipoNotaEntity;

public final class TipoNotaBusinessImpl implements TipoNotaBusiness {

	private DAOFactory daoFactory;

	public TipoNotaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoNotaDomain> list(final TipoNotaDomain domain) {
		final TipoNotaEntity entity = TipoNotaAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoNotaEntity> resultEntityList = daoFactory.getTipoNotaDAO().read(entity);

		return TipoNotaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
