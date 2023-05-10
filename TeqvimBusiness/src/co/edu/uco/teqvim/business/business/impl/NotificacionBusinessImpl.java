package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.NotificacionAssembler;
import co.edu.uco.teqvim.business.business.NotificacionBusiness;
import co.edu.uco.teqvim.business.domain.NotificacionDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.NotificacionEntity;

public final class NotificacionBusinessImpl implements NotificacionBusiness {

	private DAOFactory daoFactory;

	public NotificacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final NotificacionDomain domain) {
		final NotificacionEntity entity = NotificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getNotificacionDAO().create(entity);

	}

	@Override
	public List<NotificacionDomain> list(final NotificacionDomain domain) {
		final NotificacionEntity entity = NotificacionAssembler.getInstance().toEntityFromDomain(domain);

		List<NotificacionEntity> resultEntityList = daoFactory.getNotificacionDAO().read(entity);

		return NotificacionAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final NotificacionDomain domain) {
		final NotificacionEntity entity = NotificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getNotificacionDAO().update(entity);

	}

	@Override
	public void drop(final NotificacionDomain domain) {
		final NotificacionEntity entity = NotificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getNotificacionDAO().delete(entity);

	}

}
