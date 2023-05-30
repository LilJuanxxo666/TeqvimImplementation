package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.NombreDiaSemanaAssembler;
import co.edu.uco.teqvim.business.business.impl.NombreDiaSemanaBusinessImpl;
import co.edu.uco.teqvim.business.facade.NombreDiaSemanaFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.NombreDiasemanaFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.NombreDiaSemanaDTO;

public final class NombreDiaSemanaFacadeImpl implements NombreDiaSemanaFacade{
	
	private final DAOFactory daoFactory;
	private final NombreDiaSemanaBusinessImpl business;

	public NombreDiaSemanaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new NombreDiaSemanaBusinessImpl(daoFactory);
	}

	@Override
	public List<NombreDiaSemanaDTO> list(NombreDiaSemanaDTO dto) {
		try {
			final var domain = NombreDiaSemanaAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return NombreDiaSemanaAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = NombreDiasemanaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = NombreDiasemanaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

}
