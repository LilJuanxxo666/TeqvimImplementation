package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EstudianteAssembler;
import co.edu.uco.teqvim.business.business.EstudianteBusiness;
import co.edu.uco.teqvim.business.business.impl.EstudianteBusinessImpl;
import co.edu.uco.teqvim.business.facade.EstudianteFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudianteFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.EstudianteDTO;

public final class EstudianteFacadeImpl implements EstudianteFacade{
	
	private final DAOFactory daoFactory;
	private final EstudianteBusiness business;

	public EstudianteFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstudianteBusinessImpl(daoFactory);
	}

	@Override
	public void register(EstudianteDTO dto) {
		try {
			final var domain = EstudianteAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.register(domain);
			daoFactory.commitTransaction();

		} catch (final TeqvimException exception) {

			daoFactory.cancelTransaction();
			throw exception;

		} catch (final Exception exception) {

			daoFactory.cancelTransaction();

			var userMessage = EstudianteFacadeImplMessages.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstudianteFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public List<EstudianteDTO> list(EstudianteDTO dto) {
		try {
			daoFactory.initTransaction();
			final var domain = EstudianteAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);
			return EstudianteAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();
			throw TeqvimBusinessException.create(EstudianteFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE, EstudianteFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void modify(EstudianteDTO dto) {
		try {
			final var domain = EstudianteAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.modify(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = EstudianteFacadeImplMessages.MODIFY_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstudianteFacadeImplMessages.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void drop(EstudianteDTO dto) {
		try {
			final var domain = EstudianteAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.drop(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = EstudianteFacadeImplMessages.DROP_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstudianteFacadeImplMessages.DROP_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}

	}
}
