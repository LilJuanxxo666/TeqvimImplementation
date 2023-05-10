package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EstadoEventoAssembler;
import co.edu.uco.teqvim.business.business.EstadoEventoBusiness;
import co.edu.uco.teqvim.business.domain.EstadoEventoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.EstadoEventoEntity;

public final class EstadoEventoBusinessImpl implements EstadoEventoBusiness {

	private DAOFactory daoFactory;

	public EstadoEventoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final EstadoEventoDomain domain) {
		final EstadoEventoEntity entity = EstadoEventoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoEventoDAO().create(entity);

	}

	@Override
	public List<EstadoEventoDomain> list(final EstadoEventoDomain domain) {
		final EstadoEventoEntity entity = EstadoEventoAssembler.getInstance().toEntityFromDomain(domain);

		List<EstadoEventoEntity> resultEntityList = daoFactory.getEstadoEventoDAO().read(entity);

		return EstadoEventoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
