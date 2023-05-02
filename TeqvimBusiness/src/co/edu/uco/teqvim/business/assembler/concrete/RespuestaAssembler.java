package co.edu.uco.teqvim.business.assembler.concrete;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.RespuestaDomain;
import co.edu.uco.teqvim.dto.RespuestaDTO;
import co.edu.uco.teqvim.entities.RespuestaEntity;

public class RespuestaAssembler implements Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity>{
	
	private static final Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity> INSTANCE = new RespuestaAssembler();

	private RespuestaAssembler() {
		super();
	}

	public static Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public RespuestaDTO toDtoFromDomain(RespuestaDomain domain) {
		return RespuestaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
				setDescripcion(domain.getDescripcion());
	}

	@Override
	public RespuestaDomain toDomainFromDto(RespuestaDTO dto) {
		return new RespuestaDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public RespuestaEntity toEntityFromDomain(RespuestaDomain domain) {
		return new RespuestaEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public RespuestaDomain toDomainFromEntity(RespuestaEntity entity) {
		return new RespuestaDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

}
