package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.FestivoAssembler;
import co.edu.uco.teqvim.business.business.impl.FestivoBusinessImpl;
import co.edu.uco.teqvim.business.facade.FestivoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.FestivoFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.FestivoDTO;

public final class FestivoFacadeImpl implements FestivoFacade{
	
	private final DAOFactory daoFactory;
	private final FestivoBusinessImpl business;

	public FestivoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new FestivoBusinessImpl(daoFactory);
	}

	@Override
	public List<FestivoDTO> list(FestivoDTO dto) {
		try {
			final var domain = FestivoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return FestivoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = FestivoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = FestivoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
