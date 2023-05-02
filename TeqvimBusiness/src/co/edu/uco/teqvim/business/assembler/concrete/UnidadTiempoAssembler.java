package co.edu.uco.teqvim.business.assembler.concrete;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.UnidadTiempoDomain;
import co.edu.uco.teqvim.dto.UnidadTiempoDTO;
import co.edu.uco.teqvim.entities.UnidadTiempoEntity;

public class UnidadTiempoAssembler implements Assembler<UnidadTiempoDomain, UnidadTiempoDTO, UnidadTiempoEntity> {
	
	private static final Assembler<UnidadTiempoDomain, UnidadTiempoDTO, UnidadTiempoEntity> INSTANCE = new UnidadTiempoAssembler();

	private UnidadTiempoAssembler() {
		super();
	}

	public static Assembler<UnidadTiempoDomain, UnidadTiempoDTO, UnidadTiempoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public UnidadTiempoDTO toDtoFromDomain(UnidadTiempoDomain domain) {
		return UnidadTiempoDTO.create().setIdentificador(domain.getIdentificador()).
				setNombre(domain.getNombre());
	}

	@Override
	public UnidadTiempoDomain toDomainFromDto(UnidadTiempoDTO dto) {
		return new UnidadTiempoDomain(dto.getIdentificador(), dto.getNombre());
	}

	@Override
	public UnidadTiempoEntity toEntityFromDomain(UnidadTiempoDomain domain) {
		return new UnidadTiempoEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public UnidadTiempoDomain toDomainFromEntity(UnidadTiempoEntity entity) {
		return new UnidadTiempoDomain(entity.getIdentificador(), entity.getNombre());
	}
}
