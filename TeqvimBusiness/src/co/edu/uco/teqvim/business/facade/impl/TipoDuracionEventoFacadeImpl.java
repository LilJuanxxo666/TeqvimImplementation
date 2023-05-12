package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoDuracionEventoAssembler;
import co.edu.uco.teqvim.business.business.impl.TipoDuracionEventoBusinessImpl;
import co.edu.uco.teqvim.business.facade.TipoDuracionEventoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.TipoDuracionEventoFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.TipoDuracionEventoDTO;

public final class TipoDuracionEventoFacadeImpl implements TipoDuracionEventoFacade{
	
	private final DAOFactory daoFactory;
	private final TipoDuracionEventoBusinessImpl business;

	public TipoDuracionEventoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoDuracionEventoBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoDuracionEventoDTO> list(TipoDuracionEventoDTO dto) {
		try {
			final var domain = TipoDuracionEventoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return TipoDuracionEventoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = TipoDuracionEventoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoDuracionEventoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
