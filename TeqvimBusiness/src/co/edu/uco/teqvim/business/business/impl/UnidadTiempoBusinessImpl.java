package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.UnidadTiempoAssembler;
import co.edu.uco.teqvim.business.business.UnidadTiempoBusiness;
import co.edu.uco.teqvim.business.domain.UnidadTiempoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.UnidadTiempoEntity;

public final class UnidadTiempoBusinessImpl implements UnidadTiempoBusiness {

	private DAOFactory daoFactory;

	public UnidadTiempoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<UnidadTiempoDomain> list(final UnidadTiempoDomain domain) {
		final UnidadTiempoEntity entity = UnidadTiempoAssembler.getInstance().toEntityFromDomain(domain);

		List<UnidadTiempoEntity> resultEntityList = daoFactory.getUnidadTiempoDAO().read(entity);

		return UnidadTiempoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
