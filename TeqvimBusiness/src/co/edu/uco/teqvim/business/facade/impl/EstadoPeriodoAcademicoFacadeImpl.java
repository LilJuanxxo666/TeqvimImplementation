package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EstadoPeriodoAcademicoAssembler;
import co.edu.uco.teqvim.business.business.EstadoPeriodoAcademicoBusiness;
import co.edu.uco.teqvim.business.business.impl.EstadoPeriodoAcademicoBusinessImpl;
import co.edu.uco.teqvim.business.facade.EstadoPeriodoAcademicoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstadoPeriodoAcademicoFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.EstadoPeriodoAcademicoDTO;

public final class EstadoPeriodoAcademicoFacadeImpl implements EstadoPeriodoAcademicoFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoPeriodoAcademicoBusiness business;

	public EstadoPeriodoAcademicoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstadoPeriodoAcademicoBusinessImpl(daoFactory);
	}

	@Override
	public List<EstadoPeriodoAcademicoDTO> list(EstadoPeriodoAcademicoDTO dto) {
		try {
			final var domain = EstadoPeriodoAcademicoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return EstadoPeriodoAcademicoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = EstadoPeriodoAcademicoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoPeriodoAcademicoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

}
