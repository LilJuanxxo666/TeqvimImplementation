package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.PaisAssembler;
import co.edu.uco.teqvim.business.business.PaisBusiness;
import co.edu.uco.teqvim.business.domain.PaisDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.PaisEntity;

public final class PaisBusinessImpl implements PaisBusiness {

	private DAOFactory daoFactory;

	public PaisBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<PaisDomain> list(final PaisDomain domain) {
		final PaisEntity entity = PaisAssembler.getInstance().toEntityFromDomain(domain);

		List<PaisEntity> resultEntityList = daoFactory.getPaisDAO().read(entity);

		return PaisAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
