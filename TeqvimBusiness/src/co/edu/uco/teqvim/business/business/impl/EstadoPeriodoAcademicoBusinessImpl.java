package co.edu.uco.teqvim.business.business.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EstadoPeriodoAcademicoAssembler;
import co.edu.uco.teqvim.business.business.EstadoPeriodoAcademicoBusiness;
import co.edu.uco.teqvim.business.domain.EstadoPeriodoAcademicoDomain;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.EstadoPeriodoAcademicoEntity;

public final class EstadoPeriodoAcademicoBusinessImpl implements EstadoPeriodoAcademicoBusiness {

	private DAOFactory daoFactory;

	public EstadoPeriodoAcademicoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final EstadoPeriodoAcademicoDomain domain) {
		final EstadoPeriodoAcademicoEntity entity = EstadoPeriodoAcademicoAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getEstadoPeriodoAcademicoDAO().create(entity);

	}

	@Override
	public List<EstadoPeriodoAcademicoDomain> list(final EstadoPeriodoAcademicoDomain domain) {
		final EstadoPeriodoAcademicoEntity entity = EstadoPeriodoAcademicoAssembler.getInstance()
				.toEntityFromDomain(domain);

		List<EstadoPeriodoAcademicoEntity> resultEntityList = daoFactory.getEstadoPeriodoAcademicoDAO().read(entity);

		return EstadoPeriodoAcademicoAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

}
