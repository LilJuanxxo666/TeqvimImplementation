package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoNotificacionAssembler;
import co.edu.uco.teqvim.business.business.TipoNotificacionBusiness;
import co.edu.uco.teqvim.business.domain.TipoNotificacionDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.TipoNotificacionEntity;

public final class TipoNotificacionBusinessImpl implements TipoNotificacionBusiness {

	private DAOFactory daoFactory;

	public TipoNotificacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoNotificacionDomain> list(final TipoNotificacionDomain domain) {
		final TipoNotificacionEntity entity = TipoNotificacionAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoNotificacionEntity> resultEntityList = daoFactory.getTipoNotificacionDAO().read(entity);

		return TipoNotificacionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
