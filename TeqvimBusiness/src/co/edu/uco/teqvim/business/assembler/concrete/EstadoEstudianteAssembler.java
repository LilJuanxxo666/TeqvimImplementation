package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.EstadoEstudianteDomain;
import co.edu.uco.teqvim.dto.EstadoEstudianteDTO;
import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;

public final class EstadoEstudianteAssembler
		implements Assembler<EstadoEstudianteDomain, EstadoEstudianteDTO, EstadoEstudianteEntity> {
	private static final Assembler<EstadoEstudianteDomain, EstadoEstudianteDTO, EstadoEstudianteEntity> INSTANCE = new EstadoEstudianteAssembler();

	private EstadoEstudianteAssembler() {
		super();
	}

	public static Assembler<EstadoEstudianteDomain, EstadoEstudianteDTO, EstadoEstudianteEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EstadoEstudianteDTO toDtoFromDomain(EstadoEstudianteDomain domain) {
		return EstadoEstudianteDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}

	@Override
	public EstadoEstudianteDomain toDomainFromDto(EstadoEstudianteDTO dto) {
		return new EstadoEstudianteDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoEstudianteEntity toEntityFromDomain(EstadoEstudianteDomain domain) {
		return new EstadoEstudianteEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public EstadoEstudianteDomain toDomainFromEntity(EstadoEstudianteEntity entity) {
		return new EstadoEstudianteDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<EstadoEstudianteDomain> toDomainListFromEntityList(List<EstadoEstudianteEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<EstadoEstudianteDTO> toDTOListFromDomainList(List<EstadoEstudianteDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
