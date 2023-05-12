package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoFestivoFijoAssembler;
import co.edu.uco.teqvim.business.business.impl.TipoFestivoFijoBusinessImpl;
import co.edu.uco.teqvim.business.facade.TipoFestivoFijoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.TipoFestivoFijoFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.TipoFestivoFijoDTO;

public final class TipoFestivoFijoFacadeImpl implements TipoFestivoFijoFacade{
	
	private final DAOFactory daoFactory;
	private final TipoFestivoFijoBusinessImpl business;

	public TipoFestivoFijoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoFestivoFijoBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoFestivoFijoDTO> list(TipoFestivoFijoDTO dto) {
		try {
			final var domain = TipoFestivoFijoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return TipoFestivoFijoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = TipoFestivoFijoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoFestivoFijoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
