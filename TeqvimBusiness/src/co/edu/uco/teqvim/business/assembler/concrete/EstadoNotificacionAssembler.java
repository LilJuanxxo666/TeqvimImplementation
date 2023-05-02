package co.edu.uco.teqvim.business.assembler.concrete;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.EstadoNotificacionDomain;
import co.edu.uco.teqvim.dto.EstadoNotificacionDTO;
import co.edu.uco.teqvim.entities.EstadoNotificacionEntity;

public class EstadoNotificacionAssembler
		implements Assembler<EstadoNotificacionDomain, EstadoNotificacionDTO, EstadoNotificacionEntity> {
	private static final Assembler<EstadoNotificacionDomain, EstadoNotificacionDTO, EstadoNotificacionEntity> INSTANCE = new EstadoNotificacionAssembler();

	private EstadoNotificacionAssembler() {
		super();
	}

	public static Assembler<EstadoNotificacionDomain, EstadoNotificacionDTO, EstadoNotificacionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EstadoNotificacionDTO toDtoFromDomain(EstadoNotificacionDomain domain) {
		return EstadoNotificacionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}

	@Override
	public EstadoNotificacionDomain toDomainFromDto(EstadoNotificacionDTO dto) {
		return new EstadoNotificacionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoNotificacionEntity toEntityFromDomain(EstadoNotificacionDomain domain) {
		return new EstadoNotificacionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public EstadoNotificacionDomain toDomainFromEntity(EstadoNotificacionEntity entity) {
		return new EstadoNotificacionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

}
