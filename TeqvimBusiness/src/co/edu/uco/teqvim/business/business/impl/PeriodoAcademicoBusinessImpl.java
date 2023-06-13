package co.edu.uco.teqvim.business.business.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.business.assembler.concrete.PeriodoAcademicoAssembler;
import co.edu.uco.teqvim.business.business.PeriodoAcademicoBusiness;
import co.edu.uco.teqvim.business.domain.PeriodoAcademicoDomain;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;
import co.edu.uco.teqvim.crosscutting.utils.Messages.PeriodoAcademicoBusinessImplMessage;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.PeriodoAcademicoEntity;

public final class PeriodoAcademicoBusinessImpl implements PeriodoAcademicoBusiness {

	private DAOFactory daoFactory;

	public PeriodoAcademicoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final PeriodoAcademicoDomain domain) {
		UUID identificador;
		List<PeriodoAcademicoEntity> result;
		do {
			identificador = UtilUUID.generateNewUUID();
			result = daoFactory.getPeriodoAcademicoDAO()
					.read(PeriodoAcademicoEntity.create().setIdentificador(identificador));
		} while (!result.isEmpty());

		if (domain.getFechaInicio().isAfter(domain.getFechaFin())
				|| domain.getFechaInicio().isEqual(domain.getFechaFin())) {
			throw TeqvimBusinessException.create(PeriodoAcademicoBusinessImplMessage.DATE_IS_AFTER);
		} else if (domain.getFechaInicio().isAfter(domain.getFechaFin().plusWeeks(1))
				|| domain.getFechaInicio().isEqual(domain.getFechaFin().plusWeeks(1))) {
			throw TeqvimBusinessException.create(PeriodoAcademicoBusinessImplMessage.DATE_IS_LESS_A_WEEK);
		} else if (domain.getFechaInicio().isBefore(LocalDate.now().minusYears(1))) {
			throw TeqvimBusinessException.create(PeriodoAcademicoBusinessImplMessage.DATE_IS_INVALID);
		}

		final var domainToCreate = new PeriodoAcademicoDomain(identificador, domain.getNombre(),
				domain.getFechaInicio(), domain.getFechaFin(), domain.getTipoPeriodo(), domain.getEstado(),
				domain.getEstudiante(), domain.getPromedioPeriodo());
		daoFactory.getPeriodoAcademicoDAO().create(PeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domainToCreate));
	}

	@Override
	public List<PeriodoAcademicoDomain> list(final PeriodoAcademicoDomain domain) {
		return PeriodoAcademicoAssembler.getInstance().toDomainListFromEntityList(daoFactory.getPeriodoAcademicoDAO()
				.read(PeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domain)));
	}

	@Override
	public void modify(final PeriodoAcademicoDomain domain) {
		if (domain.getFechaInicio().isAfter(domain.getFechaFin())
				|| domain.getFechaInicio().isEqual(domain.getFechaFin())) {
			throw TeqvimBusinessException.create(PeriodoAcademicoBusinessImplMessage.DATE_IS_AFTER);
		} else if (domain.getFechaInicio().isAfter(domain.getFechaFin().plusWeeks(1))
				|| domain.getFechaInicio().isEqual(domain.getFechaFin().plusWeeks(1))) {
			throw TeqvimBusinessException.create(PeriodoAcademicoBusinessImplMessage.DATE_IS_LESS_A_WEEK);
		} else if (domain.getFechaInicio().isBefore(LocalDate.now().minusYears(1))) {
			throw TeqvimBusinessException.create(PeriodoAcademicoBusinessImplMessage.DATE_IS_INVALID);
		}
		daoFactory.getPeriodoAcademicoDAO().update(PeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domain));
	}

	@Override
	public void drop(final PeriodoAcademicoDomain domain) {
		daoFactory.getPeriodoAcademicoDAO().delete(PeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domain));
	}

}
