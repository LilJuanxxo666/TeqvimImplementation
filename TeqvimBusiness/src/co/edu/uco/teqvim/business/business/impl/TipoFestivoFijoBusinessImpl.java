package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoFestivoFijoAssembler;
import co.edu.uco.teqvim.business.business.TipoFestivoFijoBusiness;
import co.edu.uco.teqvim.business.domain.TipoFestivoFijoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.TipoFestivoFijoEntity;

public final class TipoFestivoFijoBusinessImpl implements TipoFestivoFijoBusiness {

	private DAOFactory daoFactory;

	public TipoFestivoFijoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final TipoFestivoFijoDomain domain) {
		final TipoFestivoFijoEntity entity = TipoFestivoFijoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoFestivoFijoDAO().create(entity);

	}

	@Override
	public List<TipoFestivoFijoDomain> list(final TipoFestivoFijoDomain domain) {
		final TipoFestivoFijoEntity entity = TipoFestivoFijoAssembler.getInstance().toEntityFromDomain(domain);

		List<TipoFestivoFijoEntity> resultEntityList = daoFactory.getTipoFestivoFijoDAO().read(entity);

		return TipoFestivoFijoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
