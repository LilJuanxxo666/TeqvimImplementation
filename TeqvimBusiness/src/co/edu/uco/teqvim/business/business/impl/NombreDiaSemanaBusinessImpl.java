package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.NombreDiaSemanaAssembler;
import co.edu.uco.teqvim.business.business.NombreDiaSemanaBusiness;
import co.edu.uco.teqvim.business.domain.NombreDiaSemanaDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.NombreDiaSemanaEntity;

public final class NombreDiaSemanaBusinessImpl implements NombreDiaSemanaBusiness{
	
	private DAOFactory daoFactory;

	public NombreDiaSemanaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<NombreDiaSemanaDomain> list(NombreDiaSemanaDomain domain) {
		final NombreDiaSemanaEntity entity = NombreDiaSemanaAssembler.getInstance().toEntityFromDomain(domain);

		List<NombreDiaSemanaEntity> resultEntityList = daoFactory.getNombreDiaSemanaDAO().read(entity);

		return NombreDiaSemanaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
