package co.edu.uco.teqvim.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.business.assembler.concrete.EstudianteAssembler;
import co.edu.uco.teqvim.business.business.EstudianteBusiness;
import co.edu.uco.teqvim.business.domain.EstudianteDomain;
import co.edu.uco.teqvim.crosscutting.exception.TeqvimBusinessException;
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
		EstudianteEntity entityTmp;
		List<EstudianteEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = EstudianteEntity.create().setIdentificador(identificador);
			result = daoFactory.getEstudianteDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		if (!daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setNumeroDocumento(domain.getNumeroDocumento())).isEmpty()) {
			throw TeqvimBusinessException.create(
					"El estudiante que intenta crear ya se encuentra registrado, por favor intente con un nuevo numero de identificación o de ser necesario actualizarlo");
		}else if(!daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setCorreo(domain.getCorreo())).isEmpty()){
			throw TeqvimBusinessException.create(
					"El estudiante que intenta crear ya se encuentra registrado, por favor intente con un nuevo correo electronico o de ser necesario actualizarlo");
		}
		else if(!daoFactory.getEstudianteDAO().read(EstudianteEntity.create().setNumeroTelefonico(domain.getNumeroTelefonico())).isEmpty()){
			throw TeqvimBusinessException.create(
					"El estudiante que intenta crear ya se encuentra registrado, por favor intente con un nuevo numero telefónico o de ser necesario actualizarlo");
		}
		final var domainToCreate = new EstudianteDomain(identificador, domain.getPrimerNombre(),
				domain.getSegundoNombre(), domain.getPrimerApellido(), domain.getSegudoApellido(),
				domain.getNumeroTelefonico(), domain.getCorreo(), domain.getContrasena(), domain.getFechaNacimiento(),
				domain.getTipoDocumento(), domain.getNumeroDocumento(), domain.getConfirmacionCorreo(),
				domain.getPais(), domain.getEstado());

		final EstudianteEntity entity = EstudianteAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getEstudianteDAO().create(entity);

	}

	@Override
	public List<EstudianteDomain> list(final EstudianteDomain domain) {
		final EstudianteEntity entity = EstudianteAssembler.getInstance().toEntityFromDomain(domain);

		List<EstudianteEntity> resultEntityList = daoFactory.getEstudianteDAO().read(entity);

		return EstudianteAssembler.getInstance().toDomainListFromEntityList(resultEntityList);
	}

	@Override
	public void modify(final EstudianteDomain domain) {
		daoFactory.getEstudianteDAO().update(EstudianteAssembler.getInstance().toEntityFromDomain(domain));

	}

	@Override
	public void drop(final EstudianteDomain domain) {
		final EstudianteEntity entity = EstudianteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstudianteDAO().delete(entity);

	}

}
