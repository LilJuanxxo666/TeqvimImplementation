package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoDocumentoAssembler;
import co.edu.uco.teqvim.business.business.TipoDocumentoBusiness;
import co.edu.uco.teqvim.business.domain.TipoDocumentoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.TipoDocumentoEntity;

public final class TipoDocumentoBusinessImpl implements TipoDocumentoBusiness {

	private DAOFactory daoFactory;

	public TipoDocumentoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final TipoDocumentoDomain domain) {
		final TipoDocumentoEntity entity = TipoDocumentoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoDocumentoDAO().create(entity);

	}

	@Override
	public List<TipoDocumentoDomain> list(final TipoDocumentoDomain domain) {
		final TipoDocumentoEntity entity = TipoDocumentoAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoDocumentoEntity> resultEntityList = daoFactory.getTipoDocumentoDAO().read(entity);

		return TipoDocumentoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
