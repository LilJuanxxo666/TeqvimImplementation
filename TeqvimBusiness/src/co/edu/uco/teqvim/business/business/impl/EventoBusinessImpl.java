package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EventoAssembler;
import co.edu.uco.teqvim.business.business.EventoBusiness;
import co.edu.uco.teqvim.business.domain.EventoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.EventoEntity;

public final class EventoBusinessImpl implements EventoBusiness {

	private DAOFactory daoFactory;

	public EventoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final EventoDomain domain) {
		final EventoEntity entity = EventoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEventoDAO().create(entity);

	}

	@Override
	public List<EventoDomain> list(final EventoDomain domain) {
		final EventoEntity entity = EventoAssembler.getInstance().toEntityFromDomain(domain);

		List<EventoEntity> resultEntityList = daoFactory.getEventoDAO().read(entity);

		return EventoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final EventoDomain domain) {
		final EventoEntity entity = EventoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEventoDAO().update(entity);

	}

	@Override
	public void drop(final EventoDomain domain) {
		final EventoEntity entity = EventoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEventoDAO().delete(entity);

	}

}
