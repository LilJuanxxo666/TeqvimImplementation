package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.TipoFestivoDomain;
import co.edu.uco.teqvim.dto.TipoFestivoDTO;
import co.edu.uco.teqvim.entities.TipoFestivoEntity;

public class TipoFestivoAssembler implements Assembler<TipoFestivoDomain, TipoFestivoDTO, TipoFestivoEntity> {

	private static final Assembler<TipoFestivoDomain, TipoFestivoDTO, TipoFestivoEntity> INSTANCE = new TipoFestivoAssembler();

	private TipoFestivoAssembler() {
		super();
	}

	public static Assembler<TipoFestivoDomain, TipoFestivoDTO, TipoFestivoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoFestivoDTO toDtoFromDomain(TipoFestivoDomain domain) {
		return TipoFestivoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoFestivoDomain toDomainFromDto(TipoFestivoDTO dto) {
		return new TipoFestivoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoFestivoEntity toEntityFromDomain(TipoFestivoDomain domain) {
		return new TipoFestivoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoFestivoDomain toDomainFromEntity(TipoFestivoEntity entity) {
		return new TipoFestivoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<TipoFestivoDomain> toDomainListFromEntityList(List<TipoFestivoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoFestivoDTO> toDTOListFromDomainList(List<TipoFestivoDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
