package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EstadoNotificacionAssembler;
import co.edu.uco.teqvim.business.business.EstadoNotificacionBusiness;
import co.edu.uco.teqvim.business.business.impl.EstadoNotificacionBusinessImpl;
import co.edu.uco.teqvim.business.facade.EstadoNotificacionFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstadoNotificacionFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.EstadoNotificacionDTO;

public final class EstadoNotificacionFacadeImpl implements EstadoNotificacionFacade{
	
	private final DAOFactory daoFactory;
	private final EstadoNotificacionBusiness business;
	
	public EstadoNotificacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstadoNotificacionBusinessImpl(daoFactory);
	}

	@Override
	public List<EstadoNotificacionDTO> list(EstadoNotificacionDTO dto) {
		try {
			final var domain = EstadoNotificacionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return EstadoNotificacionAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = EstadoNotificacionFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoNotificacionFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}

