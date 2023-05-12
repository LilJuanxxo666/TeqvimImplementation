package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoEventoAssembler;
import co.edu.uco.teqvim.business.business.impl.TipoEventoBusinessImpl;
import co.edu.uco.teqvim.business.facade.TipoEventoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.TipoEventoFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.TipoEventoDTO;

public final class TipoEventoFacadeImpl implements TipoEventoFacade{

	private final DAOFactory daoFactory;
	private final TipoEventoBusinessImpl business;

	public TipoEventoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoEventoBusinessImpl(daoFactory);
	}
	
	@Override
	public List<TipoEventoDTO> list(TipoEventoDTO dto) {
		try {
			final var domain = TipoEventoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return TipoEventoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = TipoEventoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoEventoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

}
