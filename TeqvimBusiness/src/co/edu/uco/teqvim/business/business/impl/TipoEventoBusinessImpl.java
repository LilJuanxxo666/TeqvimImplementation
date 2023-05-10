package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoEventoAssembler;
import co.edu.uco.teqvim.business.business.TipoEventoBusiness;
import co.edu.uco.teqvim.business.domain.TipoEventoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.TipoEventoEntity;

public final class TipoEventoBusinessImpl implements TipoEventoBusiness {

	private DAOFactory daoFactory;

	public TipoEventoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final TipoEventoDomain domain) {
		final TipoEventoEntity entity = TipoEventoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoEventoDAO().create(entity);

	}

	@Override
	public List<TipoEventoDomain> list(final TipoEventoDomain domain) {
		final TipoEventoEntity entity = TipoEventoAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoEventoEntity> resultEntityList = daoFactory.getTipoEventoDAO().read(entity);

		return TipoEventoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
