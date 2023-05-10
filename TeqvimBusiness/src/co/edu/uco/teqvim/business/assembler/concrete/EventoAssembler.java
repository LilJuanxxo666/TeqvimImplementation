package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.EventoDomain;
import co.edu.uco.teqvim.dto.EventoDTO;
import co.edu.uco.teqvim.entities.EventoEntity;

public final class EventoAssembler implements Assembler<EventoDomain, EventoDTO, EventoEntity> {

	private static final Assembler<EventoDomain, EventoDTO, EventoEntity> INSTANCE = new EventoAssembler();

	private EventoAssembler() {
		super();
	}

	public static Assembler<EventoDomain, EventoDTO, EventoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EventoDTO toDtoFromDomain(EventoDomain domain) {
		return EventoDTO.create().setIdentificador(domain.getIdentificador()).setTitulo(domain.getTitulo())
				.setDescripcion(domain.getDescripcion()).setFechaInicio(domain.getFechaInicio())
				.setFechaFin(domain.getFechaFin())
				.setEstudiante(EstudianteAssembler.getInstance().toDtoFromDomain(domain.getEstudiante()))
				.setDuracionEvento(
						TipoDuracionEventoAssembler.getInstance().toDtoFromDomain(domain.getDuracionEvento()))
				.setTipoEvento(TipoEventoAssembler.getInstance().toDtoFromDomain(domain.getTipoEvento()))
				.setEstado(EstadoEventoAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public EventoDomain toDomainFromDto(EventoDTO dto) {
		return new EventoDomain(dto.getIdentificador(), dto.getTitulo(), dto.getDescripcion(), dto.getFechaInicio(),
				dto.getFechaFin(), TipoDuracionEventoAssembler.getInstance().toDomainFromDto(dto.getDuracionEvento()),
				EstadoEventoAssembler.getInstance().toDomainFromDto(dto.getEstado()),
				TipoEventoAssembler.getInstance().toDomainFromDto(dto.getTipoEvento()),
				EstudianteAssembler.getInstance().toDomainFromDto(dto.getEstudiante()));
	}

	@Override
	public EventoEntity toEntityFromDomain(EventoDomain domain) {
		return new EventoEntity(domain.getIdentificador(), domain.getTitulo(), domain.getDescripcion(),
				domain.getFechaInicio(), domain.getFechaFin(),
				TipoDuracionEventoAssembler.getInstance().toEntityFromDomain(domain.getDuracionEvento()),
				EstadoEventoAssembler.getInstance().toEntityFromDomain(domain.getEstado()),
				TipoEventoAssembler.getInstance().toEntityFromDomain(domain.getTipoEvento()),
				EstudianteAssembler.getInstance().toEntityFromDomain(domain.getEstudiante()));
	}

	@Override
	public EventoDomain toDomainFromEntity(EventoEntity entity) {
		return new EventoDomain(entity.getIdentificador(), entity.getTitulo(), entity.getDescripcion(),
				entity.getFechaInicio(), entity.getFechaFin(),
				TipoDuracionEventoAssembler.getInstance().toDomainFromEntity(entity.getDuracionEvento()),
				EstadoEventoAssembler.getInstance().toDomainFromEntity(entity.getEstado()),
				TipoEventoAssembler.getInstance().toDomainFromEntity(entity.getTipoEvento()),
				EstudianteAssembler.getInstance().toDomainFromEntity(entity.getEstudiante()));
	}

	@Override
	public List<EventoDomain> toDomainListFromEntityList(List<EventoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<EventoDTO> toDTOListFromDomainList(List<EventoDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
