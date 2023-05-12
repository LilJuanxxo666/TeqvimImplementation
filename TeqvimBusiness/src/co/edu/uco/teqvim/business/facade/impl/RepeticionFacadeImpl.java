package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.RepeticionAssembler;
import co.edu.uco.teqvim.business.business.impl.RepeticionBusinessImpl;
import co.edu.uco.teqvim.business.facade.RepeticionFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.RepeticionFacadeImplMessage;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.RepeticionDTO;

public final class RepeticionFacadeImpl implements RepeticionFacade{
	
	private final DAOFactory daoFactory;
	private final RepeticionBusinessImpl business;

	public RepeticionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new RepeticionBusinessImpl(daoFactory);
	}

	@Override
	public void register(RepeticionDTO dto) {
		try {
			final var domain = RepeticionAssembler.getInstance().toDomainFromDto(dto);

			daoFactory.initTransaction();
			business.register(domain);
			daoFactory.commitTransaction();

		} catch (final TeqvimException exception) {

			daoFactory.cancelTransaction();
			throw exception;

		} catch (final Exception exception) {

			daoFactory.cancelTransaction();

			var userMessage = RepeticionFacadeImplMessage.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = RepeticionFacadeImplMessage.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public List<RepeticionDTO> list(RepeticionDTO dto) {
		try {
			final var domain = RepeticionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return RepeticionAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = RepeticionFacadeImplMessage.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = RepeticionFacadeImplMessage.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void modify(RepeticionDTO dto) {
		try {
			final var domain = RepeticionAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.modify(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = RepeticionFacadeImplMessage.MODIFY_EXCEPTION_USER_MESSAGE;
			var technicalMessage = RepeticionFacadeImplMessage.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void drop(RepeticionDTO dto) {
		try {
			final var domain = RepeticionAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.drop(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = RepeticionFacadeImplMessage.DROP_EXCEPTION_USER_MESSAGE;
			var technicalMessage = RepeticionFacadeImplMessage.DROP_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
