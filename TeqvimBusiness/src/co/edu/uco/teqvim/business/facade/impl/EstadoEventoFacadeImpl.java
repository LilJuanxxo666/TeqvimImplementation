package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.DuracionAssembler;
import co.edu.uco.teqvim.business.assembler.concrete.EstadoEventoAssembler;
import co.edu.uco.teqvim.business.business.EstadoEventoBusiness;
import co.edu.uco.teqvim.business.business.impl.EstadoEventoBusinessImpl;
import co.edu.uco.teqvim.business.facade.EstadoEventoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.DuracionFacadeImplMessages;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstadoEventoFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.EstadoEventoDTO;

public final class EstadoEventoFacadeImpl implements EstadoEventoFacade {

	private final DAOFactory daoFactory;;
	private final EstadoEventoBusiness business;

	public EstadoEventoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstadoEventoBusinessImpl(daoFactory);
	}

	@Override
	public void register(EstadoEventoDTO dto) {
		try {
			final var domain = EstadoEventoAssembler.getInstance().toDomainFromDto(dto);

			daoFactory.initTransaction();
			business.register(domain);
			daoFactory.commitTransaction();

		} catch (final TeqvimException exception) {

			daoFactory.cancelTransaction();
			throw exception;

		} catch (final Exception exception) {

			daoFactory.cancelTransaction();

			var userMessage = EstadoEventoFacadeImplMessages.REGISTER_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoEventoFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}

	}

	@Override
	public List<EstadoEventoDTO> list(EstadoEventoDTO dto) {
		try {
			final var domain = EstadoEventoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return EstadoEventoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = EstadoEventoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoEventoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

}
