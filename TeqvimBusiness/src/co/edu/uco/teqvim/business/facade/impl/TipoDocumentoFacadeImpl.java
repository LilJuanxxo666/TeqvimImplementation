package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoDocumentoAssembler;
import co.edu.uco.teqvim.business.business.impl.TipoDocumentoBusinessImpl;
import co.edu.uco.teqvim.business.facade.TipoDocumentoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.RespuestaFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.TipoDocumentoDTO;

public final class TipoDocumentoFacadeImpl implements TipoDocumentoFacade{
	
	private final DAOFactory daoFactory;
	private final TipoDocumentoBusinessImpl business;

	public TipoDocumentoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoDocumentoBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoDocumentoDTO> list(TipoDocumentoDTO dto) {
		try {
			final var domain = TipoDocumentoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return TipoDocumentoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = RespuestaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = RespuestaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
