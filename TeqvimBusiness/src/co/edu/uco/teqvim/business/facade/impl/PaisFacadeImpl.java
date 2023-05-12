package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.PaisAssembler;
import co.edu.uco.teqvim.business.business.impl.PaisBusinessImpl;
import co.edu.uco.teqvim.business.facade.PaisFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.PaisFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.PaisDTO;

public final class PaisFacadeImpl implements PaisFacade{
	
	private final DAOFactory daoFactory;
	private final PaisBusinessImpl business;

	public PaisFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new PaisBusinessImpl(daoFactory);
	}

	@Override
	public List<PaisDTO> list(PaisDTO dto) {
		try {
			final var domain = PaisAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return PaisAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = PaisFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = PaisFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
