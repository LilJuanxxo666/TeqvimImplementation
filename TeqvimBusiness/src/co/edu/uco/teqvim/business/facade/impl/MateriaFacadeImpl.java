package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.MateriaAssembler;
import co.edu.uco.teqvim.business.business.impl.MateriaBusinessImpl;
import co.edu.uco.teqvim.business.facade.MateriaFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.MateriaFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.MateriaDTO;

public final class MateriaFacadeImpl implements MateriaFacade{
	
	private final DAOFactory daoFactory;
	private final MateriaBusinessImpl business;

	public MateriaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new MateriaBusinessImpl(daoFactory);
	}

	@Override
	public void register(MateriaDTO dto) {
		try {
			final var domain = MateriaAssembler.getInstance().toDomainFromDto(dto);

			daoFactory.initTransaction();
			business.register(domain);
			daoFactory.commitTransaction();

		} catch (final TeqvimException exception) {

			daoFactory.cancelTransaction();
			throw exception;

		} catch (final Exception exception) {

			daoFactory.cancelTransaction();

			var userMessage = MateriaFacadeImplMessages.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = MateriaFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public List<MateriaDTO> list(MateriaDTO dto) {
		try {
			final var domain = MateriaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return MateriaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = MateriaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = MateriaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void modify(MateriaDTO dto) {
		try {
			final var domain = MateriaAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.modify(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = MateriaFacadeImplMessages.MODIFY_EXCEPTION_USER_MESSAGE;
			var technicalMessage = MateriaFacadeImplMessages.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void drop(MateriaDTO dto) {
		try {
			final var domain = MateriaAssembler.getInstance().toDomainFromDto(dto);
			daoFactory.initTransaction();
			business.drop(domain);
			daoFactory.commitTransaction();
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = MateriaFacadeImplMessages.DROP_EXCEPTION_USER_MESSAGE;
			var technicalMessage = MateriaFacadeImplMessages.DROP_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}	
	}
}
