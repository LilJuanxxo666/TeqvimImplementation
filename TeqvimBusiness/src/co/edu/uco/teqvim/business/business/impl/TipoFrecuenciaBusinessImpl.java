package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoFrecuenciaAssembler;
import co.edu.uco.teqvim.business.business.TipoFrecuenciaBusiness;
import co.edu.uco.teqvim.business.domain.TipoFrecuenciaDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.TipoFrecuenciaEntity;

public final class TipoFrecuenciaBusinessImpl implements TipoFrecuenciaBusiness {

	private DAOFactory daoFactory;

	public TipoFrecuenciaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final TipoFrecuenciaDomain domain) {
		final TipoFrecuenciaEntity entity = TipoFrecuenciaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoFrecuenciaDAO().create(entity);

	}

	@Override
	public List<TipoFrecuenciaDomain> list(final TipoFrecuenciaDomain domain) {
		final TipoFrecuenciaEntity entity = TipoFrecuenciaAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoFrecuenciaEntity> resultEntityList = daoFactory.getTipoFrecuenciaDAO().read(entity);

		return TipoFrecuenciaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
