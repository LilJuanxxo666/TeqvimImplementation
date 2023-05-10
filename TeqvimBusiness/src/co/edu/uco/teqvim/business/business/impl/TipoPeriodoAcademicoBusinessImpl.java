package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoPeriodoAcademicoAssembler;
import co.edu.uco.teqvim.business.business.TipoPeriodoAcademicoBusiness;
import co.edu.uco.teqvim.business.domain.TipoPeriodoAcademicoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.TipoPeriodoAcademicoEntity;

public final class TipoPeriodoAcademicoBusinessImpl implements TipoPeriodoAcademicoBusiness {

	private DAOFactory daoFactory;

	public TipoPeriodoAcademicoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final TipoPeriodoAcademicoDomain domain) {
		final TipoPeriodoAcademicoEntity entity = TipoPeriodoAcademicoAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getTipoPeriodoAcademicoDAO().create(entity);

	}

	@Override
	public List<TipoPeriodoAcademicoDomain> list(final TipoPeriodoAcademicoDomain domain) {
		final TipoPeriodoAcademicoEntity entity = TipoPeriodoAcademicoAssembler.getInstance()
				.toEntityFromDomain(domain);

		List<TipoPeriodoAcademicoEntity> resultEntityList = daoFactory.getTipoPeriodoAcademicoDAO().read(entity);

		return TipoPeriodoAcademicoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
