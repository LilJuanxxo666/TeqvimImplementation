package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoFrecuenciaAssembler;
import co.edu.uco.teqvim.business.business.impl.TipoFrecuenciaBusinessImpl;
import co.edu.uco.teqvim.business.facade.TipoFrecuenciaFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.TipoFrecuenciaFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.TipoFrecuenciaDTO;

public final class TipoFrecuenciaFacadeImpl implements TipoFrecuenciaFacade{
	
	private final DAOFactory daoFactory;
	private final TipoFrecuenciaBusinessImpl business;

	public TipoFrecuenciaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoFrecuenciaBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoFrecuenciaDTO> list(TipoFrecuenciaDTO dto) {
		try {
			final var domain = TipoFrecuenciaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return TipoFrecuenciaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = TipoFrecuenciaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoFrecuenciaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
