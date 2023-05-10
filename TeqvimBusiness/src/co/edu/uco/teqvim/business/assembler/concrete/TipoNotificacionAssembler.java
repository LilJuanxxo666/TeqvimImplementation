package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;

import co.edu.uco.teqvim.business.domain.TipoNotificacionDomain;
import co.edu.uco.teqvim.dto.TipoNotificacionDTO;
import co.edu.uco.teqvim.entities.TipoNotificacionEntity;

public class TipoNotificacionAssembler
		implements Assembler<TipoNotificacionDomain, TipoNotificacionDTO, TipoNotificacionEntity> {

	private static final Assembler<TipoNotificacionDomain, TipoNotificacionDTO, TipoNotificacionEntity> INSTANCE = new TipoNotificacionAssembler();

	private TipoNotificacionAssembler() {
		super();
	}

	public static Assembler<TipoNotificacionDomain, TipoNotificacionDTO, TipoNotificacionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoNotificacionDTO toDtoFromDomain(TipoNotificacionDomain domain) {
		return TipoNotificacionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoNotificacionDomain toDomainFromDto(TipoNotificacionDTO dto) {
		return new TipoNotificacionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoNotificacionEntity toEntityFromDomain(TipoNotificacionDomain domain) {
		return new TipoNotificacionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoNotificacionDomain toDomainFromEntity(TipoNotificacionEntity entity) {
		return new TipoNotificacionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<TipoNotificacionDomain> toDomainListFromEntityList(List<TipoNotificacionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoNotificacionDTO> toDTOListFromDomainList(List<TipoNotificacionDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
