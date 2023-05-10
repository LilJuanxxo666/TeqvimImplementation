package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.TipoFestivoFijoDomain;
import co.edu.uco.teqvim.dto.TipoFestivoFijoDTO;
import co.edu.uco.teqvim.entities.TipoFestivoFijoEntity;

public class TipoFestivoFijoAssembler
		implements Assembler<TipoFestivoFijoDomain, TipoFestivoFijoDTO, TipoFestivoFijoEntity> {

	private static final Assembler<TipoFestivoFijoDomain, TipoFestivoFijoDTO, TipoFestivoFijoEntity> INSTANCE = new TipoFestivoFijoAssembler();

	private TipoFestivoFijoAssembler() {
		super();
	}

	public static Assembler<TipoFestivoFijoDomain, TipoFestivoFijoDTO, TipoFestivoFijoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoFestivoFijoDTO toDtoFromDomain(TipoFestivoFijoDomain domain) {
		return TipoFestivoFijoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoFestivoFijoDomain toDomainFromDto(TipoFestivoFijoDTO dto) {
		return new TipoFestivoFijoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoFestivoFijoEntity toEntityFromDomain(TipoFestivoFijoDomain domain) {
		return new TipoFestivoFijoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoFestivoFijoDomain toDomainFromEntity(TipoFestivoFijoEntity entity) {
		return new TipoFestivoFijoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<TipoFestivoFijoDomain> toDomainListFromEntityList(List<TipoFestivoFijoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoFestivoFijoDTO> toDTOListFromDomainList(List<TipoFestivoFijoDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
