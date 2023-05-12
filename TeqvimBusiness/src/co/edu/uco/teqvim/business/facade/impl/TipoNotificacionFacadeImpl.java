package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoNotificacionAssembler;
import co.edu.uco.teqvim.business.business.impl.TipoNotificacionBusinessImpl;
import co.edu.uco.teqvim.business.facade.TipoNotificacionFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.TipoPeriodoAcademicoFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.TipoNotificacionDTO;

public final class TipoNotificacionFacadeImpl implements TipoNotificacionFacade{
	
	private final DAOFactory daoFactory;
	private final TipoNotificacionBusinessImpl business;

	public TipoNotificacionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoNotificacionBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoNotificacionDTO> list(TipoNotificacionDTO dto) {
		try {
			final var domain = TipoNotificacionAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return TipoNotificacionAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = TipoPeriodoAcademicoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoPeriodoAcademicoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

}
