package co.edu.uco.teqvim.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.business.assembler.concrete.EstudianteAssembler;
import co.edu.uco.teqvim.business.business.EstudianteBusiness;
import co.edu.uco.teqvim.business.domain.EstudianteDomain;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudianteBusinessImplMessages;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;
import co.edu.uco.teqvim.data.dao.factory.DAOFactory;
import co.edu.uco.teqvim.entities.EstudianteEntity;

public final class EstudianteBusinessImpl implements EstudianteBusiness {

	private DAOFactory daoFactory;

	public EstudianteBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(final EstudianteDomain domain) {

		UUID identificador;
		List<EstudianteEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			result = daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setIdentificador(identificador));
		}while(!result.isEmpty());
		
		if (!daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setNumeroDocumento(domain.getNumeroDocumento())).isEmpty()) {
			throw TeqvimBusinessException.create(EstudianteBusinessImplMessages.NUMERO_IDENTIFICACION_MESSAGE);
		}else if(!daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setCorreo(domain.getCorreo())).isEmpty()){
			throw TeqvimBusinessException.create(EstudianteBusinessImplMessages.CORREO_MESSAGE);
		}
		else if(!daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setNumeroTelefonico(domain.getNumeroTelefonico())).isEmpty()){
			throw TeqvimBusinessException.create(EstudianteBusinessImplMessages.NUMERO_TELEFONICO_MESSAGE);
		}
		final var domainToCreate = new EstudianteDomain(identificador, domain.getPrimerNombre(),
				domain.getSegundoNombre(), domain.getPrimerApellido(), domain.getSegudoApellido(),
				domain.getNumeroTelefonico(), domain.getCorreo(), domain.getContrasena(), domain.getFechaNacimiento(),
				domain.getTipoDocumento(), domain.getNumeroDocumento(), domain.getConfirmacionCorreo(),
				domain.getPais(), domain.getEstado());
		daoFactory.getEstudianteDAO().create(EstudianteAssembler.getInstance().toEntityFromDomain(domainToCreate));
	}

	@Override
	public List<EstudianteDomain> list(final EstudianteDomain domain) {
		return EstudianteAssembler.getInstance().toDomainListFromEntityList(daoFactory.getEstudianteDAO().read(EstudianteAssembler.getInstance().toEntityFromDomain(domain)));
	}

	@Override
	public void modify(final EstudianteDomain domain) {
		if (!daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setNumeroDocumento(domain.getNumeroDocumento())).isEmpty()) {
			throw TeqvimBusinessException.create(EstudianteBusinessImplMessages.NUMERO_IDENTIFICACION_MESSAGE);
		}else if(!daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setCorreo(domain.getCorreo())).isEmpty()){
			throw TeqvimBusinessException.create(EstudianteBusinessImplMessages.CORREO_MESSAGE);
		}
		else if(!daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setNumeroTelefonico(domain.getNumeroTelefonico())).isEmpty()){
			throw TeqvimBusinessException.create(EstudianteBusinessImplMessages.NUMERO_TELEFONICO_MESSAGE);
		}
		daoFactory.getEstudianteDAO().update(EstudianteAssembler.getInstance().toEntityFromDomain(domain));
	}

	@Override
	public void drop(final EstudianteDomain domain) {
		daoFactory.getEstudianteDAO().delete(EstudianteAssembler.getInstance().toEntityFromDomain(domain));
	}

}
