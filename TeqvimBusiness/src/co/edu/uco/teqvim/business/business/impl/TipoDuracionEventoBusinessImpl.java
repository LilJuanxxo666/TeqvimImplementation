package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoDuracionEventoAssembler;
import co.edu.uco.teqvim.business.business.TipoDuracionEventoBusiness;
import co.edu.uco.teqvim.business.domain.TipoDuracionEventoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.TipoDuracionEventoEntity;

public final class TipoDuracionEventoBusinessImpl implements TipoDuracionEventoBusiness {

	private DAOFactory daoFactory;

	public TipoDuracionEventoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoDuracionEventoDomain> list(final TipoDuracionEventoDomain domain) {
		final TipoDuracionEventoEntity entity = TipoDuracionEventoAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoDuracionEventoEntity> resultEntityList = daoFactory.getTipoDuracionEventoDAO().read(entity);

		return TipoDuracionEventoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
