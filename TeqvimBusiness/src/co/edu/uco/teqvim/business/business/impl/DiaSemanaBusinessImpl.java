package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.DiaSemanaAssembler;
import co.edu.uco.teqvim.business.business.DiaSemanaBusiness;
import co.edu.uco.teqvim.business.domain.DiaSemanaDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.DiaSemanaEntity;

public final class DiaSemanaBusinessImpl implements DiaSemanaBusiness{
	
	private DAOFactory daoFactory;

	public DiaSemanaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final DiaSemanaDomain domain) {
		final DiaSemanaEntity entity = DiaSemanaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getDiaSemanaDAO().create(entity);

	}

	@Override
	public List<DiaSemanaDomain> list(final DiaSemanaDomain domain) {
		final DiaSemanaEntity entity = DiaSemanaAssembler.getInstance().toEntityFromDomain(domain);

		List<DiaSemanaEntity> resultEntityList = daoFactory.getDiaSemanaDAO().read(entity);

		return DiaSemanaAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final DiaSemanaDomain domain) {
		final DiaSemanaEntity entity = DiaSemanaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getDiaSemanaDAO().update(entity);

	}

	@Override
	public void drop(final DiaSemanaDomain domain) {
		final DiaSemanaEntity entity = DiaSemanaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getDiaSemanaDAO().delete(entity);

	}

}
