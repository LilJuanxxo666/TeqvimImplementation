package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.RespuestaAssembler;
import co.edu.uco.teqvim.business.business.RespuestaBusiness;
import co.edu.uco.teqvim.business.domain.RespuestaDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.RespuestaEntity;

public final class RespuestaBusinessImpl implements RespuestaBusiness {

	private DAOFactory daoFactory;

	public RespuestaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<RespuestaDomain> list(final RespuestaDomain domain) {
		final RespuestaEntity entity = RespuestaAssembler.getInstance().toEntityFromDomain(domain);

		List<RespuestaEntity> resultEntityList = daoFactory.getRespuestaDAO().read(entity);

		return RespuestaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
