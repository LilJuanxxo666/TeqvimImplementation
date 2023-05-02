package co.edu.uco.teqvim.business.assembler.concrete;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.EstadoEventoDomain;
import co.edu.uco.teqvim.dto.EstadoEventoDTO;
import co.edu.uco.teqvim.entities.EstadoEventoEntity;

public class EstadoEventoAssembler implements Assembler<EstadoEventoDomain, EstadoEventoDTO, EstadoEventoEntity> {
	
	private static final Assembler<EstadoEventoDomain, EstadoEventoDTO, EstadoEventoEntity> INSTANCE = new EstadoEventoAssembler();

	private EstadoEventoAssembler() {
		super();
	}

	public static Assembler<EstadoEventoDomain, EstadoEventoDTO, EstadoEventoEntity> getInstance() {
		return INSTANCE;
	}
	@Override
	public EstadoEventoDTO toDtoFromDomain(EstadoEventoDomain domain) {
		return EstadoEventoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public EstadoEventoDomain toDomainFromDto(EstadoEventoDTO dto) {
		return new EstadoEventoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoEventoEntity toEntityFromDomain(EstadoEventoDomain domain) {
		return new EstadoEventoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public EstadoEventoDomain toDomainFromEntity(EstadoEventoEntity entity) {
		return new EstadoEventoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

}
