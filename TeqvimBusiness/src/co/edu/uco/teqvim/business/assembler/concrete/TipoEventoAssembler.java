package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.TipoEventoDomain;
import co.edu.uco.teqvim.dto.TipoEventoDTO;
import co.edu.uco.teqvim.entities.TipoEventoEntity;

public class TipoEventoAssembler implements Assembler<TipoEventoDomain, TipoEventoDTO, TipoEventoEntity> {

	private static final Assembler<TipoEventoDomain, TipoEventoDTO, TipoEventoEntity> INSTANCE = new TipoEventoAssembler();

	private TipoEventoAssembler() {
		super();
	}

	public static Assembler<TipoEventoDomain, TipoEventoDTO, TipoEventoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoEventoDTO toDtoFromDomain(TipoEventoDomain domain) {
		return TipoEventoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoEventoDomain toDomainFromDto(TipoEventoDTO dto) {
		return new TipoEventoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoEventoEntity toEntityFromDomain(TipoEventoDomain domain) {
		return new TipoEventoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoEventoDomain toDomainFromEntity(TipoEventoEntity entity) {
		return new TipoEventoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<TipoEventoDomain> toDomainListFromEntityList(List<TipoEventoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoEventoDTO> toDTOListFromDomainList(List<TipoEventoDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
