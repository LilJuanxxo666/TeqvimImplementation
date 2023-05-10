package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.NotificacionDomain;
import co.edu.uco.teqvim.dto.NotificacionDTO;
import co.edu.uco.teqvim.entities.NotificacionEntity;

public class NotificacionAssembler implements Assembler<NotificacionDomain, NotificacionDTO, NotificacionEntity> {

	private static final Assembler<NotificacionDomain, NotificacionDTO, NotificacionEntity> INSTANCE = new NotificacionAssembler();

	private NotificacionAssembler() {
		super();
	}

	public static Assembler<NotificacionDomain, NotificacionDTO, NotificacionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public NotificacionDTO toDtoFromDomain(NotificacionDomain domain) {
		return NotificacionDTO.create().setIdentificador(domain.getIdentificador())
				.setUnidadTiempo(UnidadTiempoAssembler.getInstance().toDtoFromDomain(domain.getUnidadTiempo()))
				.setCantidadTiempo(domain.getCantidadTiempo())
				.setTipoNotificacion(
						TipoNotificacionAssembler.getInstance().toDtoFromDomain(domain.getTipoNotificacion()))
				.setEvento(EventoAssembler.getInstance().toDtoFromDomain(domain.getEvento()))
				.setUnidadTiempo(UnidadTiempoAssembler.getInstance().toDtoFromDomain(domain.getUnidadTiempo()));
	}

	@Override
	public NotificacionDomain toDomainFromDto(NotificacionDTO dto) {
		return new NotificacionDomain(dto.getIdentificador(),
				EventoAssembler.getInstance().toDomainFromDto(dto.getEvento()), dto.getCantidadTiempo(),
				UnidadTiempoAssembler.getInstance().toDomainFromDto(dto.getUnidadTiempo()),
				TipoNotificacionAssembler.getInstance().toDomainFromDto(dto.getTipoNotificacion()),
				EstadoNotificacionAssembler.getInstance().toDomainFromDto(dto.getEstado()));
	}

	@Override
	public NotificacionEntity toEntityFromDomain(NotificacionDomain domain) {
		return new NotificacionEntity(domain.getIdentificador(),
				EventoAssembler.getInstance().toEntityFromDomain(domain.getEvento()), domain.getCantidadTiempo(),
				UnidadTiempoAssembler.getInstance().toEntityFromDomain(domain.getUnidadTiempo()),
				TipoNotificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoNotificacion()),
				EstadoNotificacionAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public NotificacionDomain toDomainFromEntity(NotificacionEntity entity) {
		return new NotificacionDomain(entity.getIdentificador(),
				EventoAssembler.getInstance().toDomainFromEntity(entity.getEvento()), entity.getCantidadTiempo(),
				UnidadTiempoAssembler.getInstance().toDomainFromEntity(entity.getUnidadTiempo()),
				TipoNotificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoNotificacion()),
				EstadoNotificacionAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<NotificacionDomain> toDomainListFromEntityList(List<NotificacionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<NotificacionDTO> toDTOListFromDomainList(List<NotificacionDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
