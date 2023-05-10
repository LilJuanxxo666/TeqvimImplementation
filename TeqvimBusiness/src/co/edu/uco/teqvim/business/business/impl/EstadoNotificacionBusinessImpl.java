package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EstadoNotificacionAssembler;
import co.edu.uco.teqvim.business.business.EstadoNotificacionBusiness;
import co.edu.uco.teqvim.business.domain.EstadoNotificacionDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.EstadoNotificacionEntity;

public final class EstadoNotificacionBusinessImpl implements EstadoNotificacionBusiness {

	private DAOFactory daoFactory;

	public EstadoNotificacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final EstadoNotificacionDomain domain) {
		final EstadoNotificacionEntity entity = EstadoNotificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoNotificacionDAO().create(entity);

	}

	@Override
	public List<EstadoNotificacionDomain> list(final EstadoNotificacionDomain domain) {
		final EstadoNotificacionEntity entity = EstadoNotificacionAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoNotificacionEntity> resultEntityList = daoFactory.getEstadoNotificacionDAO().read(entity);

		return EstadoNotificacionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
