package co.edu.uco.teqvim.business.assembler.concrete;

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
				.setContraseña(domain.getContraseña()).setCorreo(domain.getCorreo())
				.setPais(PaisAssembler.getInstance().toDtoFromDomain(domain.getPais()))
				.setConfirmacionCorreo(RespuestaAssembler.getInstance().toDtoFromDomain(domain.getConfirmacionCorreo()))
				.setTipoDocumento(TipoDocumentoAssembler.getInstance().toDtoFromDomain(domain.getTipoDocumento()))
				.setNumeroDocumento(domain.getNumeroDocumento()).setFechaNacimiento(domain.getFechaNacimiento())
				.setNumeroTelefonico(domain.getNumeroTelefonico())
				.setTipoPeriodoAcademico(
						TipoPeriodoAcademicoAssembler.getInstance().toDtoFromDomain(domain.getTipoPeriodoAcademico()))
				.setEstado(EstadoEstudianteAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public EstudianteDomain toDomainFromDto(EstudianteDTO dto) {
		return new EstudianteDomain(dto.getIdentificador(), dto.getPrimerNombre(), dto.getSegundoNombre(),
				dto.getPrimerApellido(), dto.getSegudoApellido(), dto.getNumeroTelefonico(), dto.getCorreo(), dto.getContraseña(),
				dto.getFechaNacimiento(), TipoDocumentoAssembler.getInstance().toDomainFromDto(dto.getTipoDocumento()),
				dto.getNumeroDocumento(), RespuestaAssembler.getInstance().toDomainFromDto(dto.getConfirmacionCorreo()),
				TipoPeriodoAcademicoAssembler.getInstance().toDomainFromDto(dto.getTipoPeriodoAcademico()), PaisAssembler.getInstance().toDomainFromDto(dto.getPais()), 
				EstadoEstudianteAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public EstudianteEntity toEntityFromDomain(EstudianteDomain domain) {
		return new EstudianteEntity(domain.getIdentificador(), domain.getPrimerNombre(), domain.getSegundoNombre(),
				domain.getPrimerApellido(), domain.getSegudoApellido(), domain.getNumeroTelefonico(), domain.getCorreo(), domain.getContraseña(),
				domain.getFechaNacimiento(), TipoDocumentoAssembler.getInstance().toEntityFromDomain(domain.getTipoDocumento()),
				domain.getNumeroDocumento(), RespuestaAssembler.getInstance().toEntityFromDomain(domain.getConfirmacionCorreo()),
				TipoPeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domain.getTipoPeriodoAcademico()), PaisAssembler.getInstance().toEntityFromDomain(domain.getPais()), 
				EstadoEstudianteAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public EstudianteDomain toDomainFromEntity(EstudianteEntity entity) {
		return new EstudianteDomain(entity.getIdentificador(), entity.getPrimerNombre(), entity.getSegundoNombre(),
				entity.getPrimerApellido(), entity.getSegudoApellido(), entity.getNumeroTelefonico(), entity.getCorreo(), entity.getContraseña(),
				entity.getFechaNacimiento(), TipoDocumentoAssembler.getInstance().toDomainFromEntity(entity.getTipoDocumento()),
				entity.getNumeroDocumento(), RespuestaAssembler.getInstance().toDomainFromEntity(entity.getConfirmacionCorreo()),
				TipoPeriodoAcademicoAssembler.getInstance().toDomainFromEntity(entity.getTipoPeriodoAcademico()), PaisAssembler.getInstance().toDomainFromEntity(entity.getPais()), 
				EstadoEstudianteAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

}
