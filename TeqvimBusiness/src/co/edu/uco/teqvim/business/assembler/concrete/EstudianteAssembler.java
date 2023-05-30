package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.EstudianteDomain;
import co.edu.uco.teqvim.dto.EstudianteDTO;
import co.edu.uco.teqvim.entities.EstudianteEntity;

public class EstudianteAssembler implements Assembler<EstudianteDomain, EstudianteDTO, EstudianteEntity> {
	private static final Assembler<EstudianteDomain, EstudianteDTO, EstudianteEntity> INSTANCE = new EstudianteAssembler();

	private EstudianteAssembler() {
		super();
	}

	public static Assembler<EstudianteDomain, EstudianteDTO, EstudianteEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EstudianteDTO toDtoFromDomain(EstudianteDomain domain) {
		return EstudianteDTO.create().setIdentificador(domain.getIdentificador())
				.setPrimerNombre(domain.getPrimerNombre()).setSegundoNombre(domain.getSegundoNombre())
				.setPrimerApellido(domain.getPrimerApellido()).setSegudoApellido(domain.getSegudoApellido())
				.setContrasena(domain.getContrasena()).setCorreo(domain.getCorreo())
				.setPais(PaisAssembler.getInstance().toDtoFromDomain(domain.getPais()))
				.setConfirmacionCorreo(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getConfirmacionCorreo()))
				.setTipoDocumento(TipoDocumentoAssembler.getInstance().toDtoFromDomain(domain.getTipoDocumento()))
				.setNumeroDocumento(domain.getNumeroDocumento()).setFechaNacimiento(domain.getFechaNacimiento())
				.setNumeroTelefonico(domain.getNumeroTelefonico())
				.setEstado(EstadoEstudianteAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public EstudianteDomain toDomainFromDto(EstudianteDTO dto) {
		return new EstudianteDomain(dto.getIdentificador(), dto.getPrimerNombre(), dto.getSegundoNombre(),
				dto.getPrimerApellido(), dto.getSegudoApellido(), dto.getNumeroTelefonico(), dto.getCorreo(),
				dto.getContrasena(), dto.getFechaNacimiento(),
				TipoDocumentoAssembler.getInstance().toDomainFromDto(dto.getTipoDocumento()), dto.getNumeroDocumento(),
				RespuestaAssembler.getInstance().toDomainFromDto(dto.getConfirmacionCorreo()),
				PaisAssembler.getInstance().toDomainFromDto(dto.getPais()),
				EstadoEstudianteAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public EstudianteEntity toEntityFromDomain(EstudianteDomain domain) {
		return new EstudianteEntity(domain.getIdentificador(), domain.getPrimerNombre(), domain.getSegundoNombre(),
				domain.getPrimerApellido(), domain.getSegudoApellido(), domain.getNumeroTelefonico(),
				domain.getCorreo(), domain.getContrasena(), domain.getFechaNacimiento(),
				TipoDocumentoAssembler.getInstance().toEntityFromDomain(domain.getTipoDocumento()),
				domain.getNumeroDocumento(),
				RespuestaAssembler.getInstance().toEntityFromDomain(domain.getConfirmacionCorreo()),
				PaisAssembler.getInstance().toEntityFromDomain(domain.getPais()),
				EstadoEstudianteAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public EstudianteDomain toDomainFromEntity(EstudianteEntity entity) {
		return new EstudianteDomain(entity.getIdentificador(), entity.getPrimerNombre(), entity.getSegundoNombre(),
				entity.getPrimerApellido(), entity.getSegudoApellido(), entity.getNumeroTelefonico(),
				entity.getCorreo(), entity.getContrasena(), entity.getFechaNacimiento(),
				TipoDocumentoAssembler.getInstance().toDomainFromEntity(entity.getTipoDocumento()),
				entity.getNumeroDocumento(),
				RespuestaAssembler.getInstance().toDomainFromEntity(entity.getConfirmacionCorreo()),
				PaisAssembler.getInstance().toDomainFromEntity(entity.getPais()),
				EstadoEstudianteAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<EstudianteDomain> toDomainListFromEntityList(List<EstudianteEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<EstudianteDTO> toDTOListFromDomainList(List<EstudianteDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
