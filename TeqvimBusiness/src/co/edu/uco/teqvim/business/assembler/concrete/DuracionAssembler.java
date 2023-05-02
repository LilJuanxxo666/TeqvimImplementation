package co.edu.uco.teqvim.business.assembler.concrete;

import co.edu.uco.teqvim.business.assembler.Assembler;

import co.edu.uco.teqvim.business.domain.DuracionDomain;
import co.edu.uco.teqvim.dto.DuracionDTO;
import co.edu.uco.teqvim.entities.DuracionEntity;

public class DuracionAssembler implements Assembler<DuracionDomain, DuracionDTO, DuracionEntity>{
	
	private static final Assembler<DuracionDomain, DuracionDTO, DuracionEntity> INSTANCE = new DuracionAssembler();

	private DuracionAssembler() {
		super();
	}

	public static Assembler<DuracionDomain, DuracionDTO, DuracionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public DuracionDTO toDtoFromDomain(DuracionDomain domain) {
		return DuracionDTO.create().setIdentificador(domain.getIdentificador()).setCantidadTiempo(domain.getCantidadTiempo()).
				setUnidadTiempo(UnidadTiempoAssembler.getInstance().toDtoFromDomain(domain.getUnidadTiempo()));
	}

	@Override
	public DuracionDomain toDomainFromDto(DuracionDTO dto) {
		return new DuracionDomain(dto.getIdentificador(), dto.getCantidadTiempo(), UnidadTiempoAssembler.getInstance().toDomainFromDto(dto.getUnidadTiempo()));
	}

	@Override
	public DuracionEntity toEntityFromDomain(DuracionDomain domain) {
		return new DuracionEntity(domain.getIdentificador(), domain.getCantidadTiempo(), UnidadTiempoAssembler.getInstance().toEntityFromDomain(domain.getUnidadTiempo()));
	}

	@Override
	public DuracionDomain toDomainFromEntity(DuracionEntity entity) {
		return new DuracionDomain(entity.getIdentificador(), entity.getCantidadTiempo(), UnidadTiempoAssembler.getInstance().toDomainFromEntity(entity.getUnidadTiempo()));
	}

}
