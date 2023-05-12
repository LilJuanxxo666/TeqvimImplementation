package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.PeriodoAcademicoAssembler;
import co.edu.uco.teqvim.business.business.impl.PeriodoAcademicoBusinessImpl;
import co.edu.uco.teqvim.business.facade.PeriodoAcademicoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.PeriodoAcademicoFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.PeriodoAcademicoDTO;

public final class PeriodoAcademicoFacadeImpl implements PeriodoAcademicoFacade{
	
	private final DAOFactory daoFactory;
	private final PeriodoAcademicoBusinessImpl business;

	public PeriodoAcademicoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new PeriodoAcademicoBusinessImpl(daoFactory);
	}

	@Override
	public void register(PeriodoAcademicoDTO dto) {
		try {
			final var domain = PeriodoAcademicoAssembler.getInstance().toDomainFromDto(dto);

			daoFactory.initTransaction();
			business.register(domain);
			daoFactory.commitTransaction();

		} catch (final TeqvimException exception) {

			daoFactory.cancelTransaction();
			throw exception;

		} catch (final Exception exception) {

			daoFactory.cancelTransaction();

			var userMessage = PeriodoAcademicoFacadeImplMessages.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = PeriodoAcademicoFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public List<PeriodoAcademicoDTO> list(PeriodoAcademicoDTO dto) {
		try {
			final var domain = PeriodoAcademicoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return PeriodoAcademicoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = PeriodoAcademicoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = PeriodoAcademicoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void modify(PeriodoAcademicoDTO dto) {
		try {
			final var domain = PeriodoAcademicoAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.modify(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = PeriodoAcademicoFacadeImplMessages.MODIFY_EXCEPTION_USER_MESSAGE;
			var technicalMessage = PeriodoAcademicoFacadeImplMessages.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void drop(PeriodoAcademicoDTO dto) {
		try {
			final var domain = PeriodoAcademicoAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.drop(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = PeriodoAcademicoFacadeImplMessages.DROP_EXCEPTION_USER_MESSAGE;
			var technicalMessage = PeriodoAcademicoFacadeImplMessages.DROP_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
