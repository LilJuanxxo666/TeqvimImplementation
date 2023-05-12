package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.RespuestaAssembler;
import co.edu.uco.teqvim.business.business.impl.RespuestaBusinessImpl;
import co.edu.uco.teqvim.business.facade.RespuestaFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.RespuestaFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.RespuestaDTO;

public final class RespuestaFacadeImpl implements RespuestaFacade{
	
	private final DAOFactory daoFactory;
	private final RespuestaBusinessImpl business;

	public RespuestaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new RespuestaBusinessImpl(daoFactory);
	}

	@Override
	public List<RespuestaDTO> list(RespuestaDTO dto) {
		try {
			final var domain = RespuestaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return RespuestaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
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
