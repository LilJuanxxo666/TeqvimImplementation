package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.concrete.EstadoEstudianteAssembler;
import co.edu.uco.teqvim.business.business.EstadoEstudianteBusiness;
import co.edu.uco.teqvim.business.business.impl.EstadoEstudianteBusinessImpl;
import co.edu.uco.teqvim.business.facade.EstadoEstudianteFacade;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstadoEstudianteFacadeImplMessages;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.data.dao.factory.Factory;
import co.edu.uco.teqvim.dto.EstadoEstudianteDTO;

public final class EstadoEstudianteFacadeImpl implements EstadoEstudianteFacade {

	private final DAOFactory daoFactory;;
	private final EstadoEstudianteBusiness business;

	public EstadoEstudianteFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstadoEstudianteBusinessImpl(daoFactory);
	}

	@Override
	public List<EstadoEstudianteDTO> list(EstadoEstudianteDTO dto) {
		try {
			final var domain = EstadoEstudianteAssembler.getInstance().toDomainFromDto(dto);
			final var returnDomainList = business.list(domain);

			return EstadoEstudianteAssembler.getInstance().toDTOListFromDomainList(returnDomainList);
		} catch (final TeqvimException exception) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelTransaction();

			var userMessage = EstadoEstudianteFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			var technicalMessage = EstadoEstudianteFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;

			throw TeqvimBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

}
