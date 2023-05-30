package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;


import co.edu.uco.teqvim.business.assembler.concrete.UnidadTiempoAssembler;
import co.edu.uco.teqvim.business.business.impl.UnidadTiempoBusinessImpl;
import co.edu.uco.teqvim.business.facade.UnidadTiempoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.UnidadTiempoFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.UnidadTiempoDTO;

public final class UnidadTiempoFacadeImpl implements UnidadTiempoFacade{
	
	private final DAOFactory daoFactory;
	private final UnidadTiempoBusinessImpl business;

	public UnidadTiempoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new UnidadTiempoBusinessImpl(daoFactory);
	}

	@Override
	public List<UnidadTiempoDTO> list(UnidadTiempoDTO dto) {
		try {
			final var domain = UnidadTiempoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return UnidadTiempoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = UnidadTiempoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = UnidadTiempoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

}
