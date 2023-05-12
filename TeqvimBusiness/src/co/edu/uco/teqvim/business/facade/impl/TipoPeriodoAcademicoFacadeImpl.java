package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.TipoPeriodoAcademicoAssembler;
import co.edu.uco.teqvim.business.business.impl.TipoPeriodoAcademicoBusinessImpl;
import co.edu.uco.teqvim.business.facade.TipoPeriodoAcademicoFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.TipoNotaFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.TipoPeriodoAcademicoDTO;

public final class TipoPeriodoAcademicoFacadeImpl implements TipoPeriodoAcademicoFacade{
	
	private final DAOFactory daoFactory;
	private final TipoPeriodoAcademicoBusinessImpl business;

	public TipoPeriodoAcademicoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoPeriodoAcademicoBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoPeriodoAcademicoDTO> list(TipoPeriodoAcademicoDTO dto) {
		try {
			final var domain = TipoPeriodoAcademicoAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return TipoPeriodoAcademicoAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = TipoNotaFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = TipoNotaFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}
}
