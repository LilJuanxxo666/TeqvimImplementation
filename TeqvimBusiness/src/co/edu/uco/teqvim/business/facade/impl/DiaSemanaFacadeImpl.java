package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.DiaSemanaAssembler;
import co.edu.uco.teqvim.business.business.impl.DiaSemanaBusinessImpl;
import co.edu.uco.teqvim.business.facade.DiaSemanaFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.DiaSemanaFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.DiaSemanaDTO;

public final class DiaSemanaFacadeImpl implements DiaSemanaFacade{
	
	private final DAOFactory daoFactory;
	private final DiaSemanaBusinessImpl business;

	public DiaSemanaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new DiaSemanaBusinessImpl(daoFactory);
	}

	@Override
	public void register(DiaSemanaDTO dto) {
		try {
			final var domain = DiaSemanaAssembler.getInstance().toDomainFromDto(dto);

			daoFactory.initTransaction();
			business.register(domain);
			daoFactory.commitTransaction();

		} catch (final TeqvimException exception) {

			daoFactory.cancelTransaction();
			throw exception;

		} catch (final Exception exception) {

			daoFactory.cancelTransaction();

			var userMessage = DiaSemanaFacadeImplMessages.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = DiaSemanaFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}

	}

	@Override
	public List<DiaSemanaDTO> list(DiaSemanaDTO dto) {
		try {
			final var domain = DiaSemanaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return DiaSemanaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = DiaSemanaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = DiaSemanaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void modify(DiaSemanaDTO dto) {
		try {
			final var domain = DiaSemanaAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.modify(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = DiaSemanaFacadeImplMessages.MODIFY_EXCEPTION_USER_MESSAGE;
			var technicalMessage = DiaSemanaFacadeImplMessages.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}

	}

	@Override
	public void drop(DiaSemanaDTO dto) {
		try {
			final var domain = DiaSemanaAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.drop(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = DiaSemanaFacadeImplMessages.DROP_EXCEPTION_USER_MESSAGE;
			var technicalMessage = DiaSemanaFacadeImplMessages.DROP_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}

	}

}
