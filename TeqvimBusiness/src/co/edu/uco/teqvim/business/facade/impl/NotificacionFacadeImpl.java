package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.NotificacionAssembler;
import co.edu.uco.teqvim.business.business.impl.NotificacionBusinessImpl;
import co.edu.uco.teqvim.business.facade.NotificacionFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.NotificacionFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.NotificacionDTO;

public final class NotificacionFacadeImpl implements NotificacionFacade{
	
	private final DAOFactory daoFactory;
	private final NotificacionBusinessImpl business;

	public NotificacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new NotificacionBusinessImpl(daoFactory);
	}

	@Override
	public void register(NotificacionDTO dto) {
		try {
			final var domain = NotificacionAssembler.getInstance().toDomainFromDto(dto);

			daoFactory.initTransaction();
			business.register(domain);
			daoFactory.commitTransaction();

		} catch (final TeqvimException exception) {

			daoFactory.cancelTransaction();
			throw exception;

		} catch (final Exception exception) {

			daoFactory.cancelTransaction();

			var userMessage = NotificacionFacadeImplMessages.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = NotificacionFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public List<NotificacionDTO> list(NotificacionDTO dto) {
		try {
			final var domain = NotificacionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return NotificacionAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = NotificacionFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = NotificacionFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void modify(NotificacionDTO dto) {
		try {
			final var domain = NotificacionAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.modify(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = NotificacionFacadeImplMessages.MODIFY_EXCEPTION_USER_MESSAGE;
			var technicalMessage = NotificacionFacadeImplMessages.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void drop(NotificacionDTO dto) {
		try {
			final var domain = NotificacionAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.drop(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = NotificacionFacadeImplMessages.DROP_EXCEPTION_USER_MESSAGE;
			var technicalMessage = NotificacionFacadeImplMessages.DROP_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
