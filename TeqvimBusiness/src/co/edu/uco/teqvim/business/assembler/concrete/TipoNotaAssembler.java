package co.edu.uco.teqvim.business.assembler.concrete;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.TipoNotaDomain;
import co.edu.uco.teqvim.dto.TipoNotaDTO;
import co.edu.uco.teqvim.entities.TipoNotaEntity;

public class TipoNotaAssembler implements Assembler<TipoNotaDomain, TipoNotaDTO, TipoNotaEntity>{
	
	private static final Assembler<TipoNotaDomain, TipoNotaDTO, TipoNotaEntity> INSTANCE = new TipoNotaAssembler();

	private TipoNotaAssembler() {
		super();
	}

	public static Assembler<TipoNotaDomain, TipoNotaDTO, TipoNotaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoNotaDTO toDtoFromDomain(TipoNotaDomain domain) {
		return TipoNotaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoNotaDomain toDomainFromDto(TipoNotaDTO dto) {
		return new TipoNotaDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoNotaEntity toEntityFromDomain(TipoNotaDomain domain) {
		return new TipoNotaEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoNotaDomain toDomainFromEntity(TipoNotaEntity entity) {
		return new TipoNotaDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}
	
}
