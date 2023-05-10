package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.TipoDuracionEventoDomain;
import co.edu.uco.teqvim.dto.TipoDuracionEventoDTO;
import co.edu.uco.teqvim.entities.TipoDuracionEventoEntity;

public class TipoDuracionEventoAssembler
		implements Assembler<TipoDuracionEventoDomain, TipoDuracionEventoDTO, TipoDuracionEventoEntity> {

	private static final Assembler<TipoDuracionEventoDomain, TipoDuracionEventoDTO, TipoDuracionEventoEntity> INSTANCE = new TipoDuracionEventoAssembler();

	private TipoDuracionEventoAssembler() {
		super();
	}

	public static Assembler<TipoDuracionEventoDomain, TipoDuracionEventoDTO, TipoDuracionEventoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoDuracionEventoDTO toDtoFromDomain(TipoDuracionEventoDomain domain) {
		return TipoDuracionEventoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoDuracionEventoDomain toDomainFromDto(TipoDuracionEventoDTO dto) {
		return new TipoDuracionEventoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoDuracionEventoEntity toEntityFromDomain(TipoDuracionEventoDomain domain) {
		return new TipoDuracionEventoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoDuracionEventoDomain toDomainFromEntity(TipoDuracionEventoEntity entity) {
		return new TipoDuracionEventoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<TipoDuracionEventoDomain> toDomainListFromEntityList(List<TipoDuracionEventoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoDuracionEventoDTO> toDTOListFromDomainList(List<TipoDuracionEventoDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
