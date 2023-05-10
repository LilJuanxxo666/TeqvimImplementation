package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.PeriodoAcademicoAssembler;
import co.edu.uco.teqvim.business.business.PeriodoAcademicoBusiness;
import co.edu.uco.teqvim.business.domain.PeriodoAcademicoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.PeriodoAcademicoEntity;

public final class PeriodoAcademicoBusinessImpl implements PeriodoAcademicoBusiness {

	private DAOFactory daoFactory;

	public PeriodoAcademicoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final PeriodoAcademicoDomain domain) {
		final PeriodoAcademicoEntity entity = PeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPeriodoAcademicoDAO().create(entity);

	}

	@Override
	public List<PeriodoAcademicoDomain> list(final PeriodoAcademicoDomain domain) {
		final PeriodoAcademicoEntity entity = PeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domain);

		List<PeriodoAcademicoEntity> resultEntityList = daoFactory.getPeriodoAcademicoDAO().read(entity);

		return PeriodoAcademicoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final PeriodoAcademicoDomain domain) {
		final PeriodoAcademicoEntity entity = PeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPeriodoAcademicoDAO().update(entity);

	}

	@Override
	public void drop(final PeriodoAcademicoDomain domain) {
		final PeriodoAcademicoEntity entity = PeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPeriodoAcademicoDAO().delete(entity);

	}

}
