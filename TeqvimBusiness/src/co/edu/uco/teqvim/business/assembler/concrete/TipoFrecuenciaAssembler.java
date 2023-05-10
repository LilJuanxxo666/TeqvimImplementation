package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.TipoFrecuenciaDomain;
import co.edu.uco.teqvim.dto.TipoFrecuenciaDTO;
import co.edu.uco.teqvim.entities.TipoFrecuenciaEntity;

public class TipoFrecuenciaAssembler
		implements Assembler<TipoFrecuenciaDomain, TipoFrecuenciaDTO, TipoFrecuenciaEntity> {

	private static final Assembler<TipoFrecuenciaDomain, TipoFrecuenciaDTO, TipoFrecuenciaEntity> INSTANCE = new TipoFrecuenciaAssembler();

	private TipoFrecuenciaAssembler() {
		super();
	}

	public static Assembler<TipoFrecuenciaDomain, TipoFrecuenciaDTO, TipoFrecuenciaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoFrecuenciaDTO toDtoFromDomain(TipoFrecuenciaDomain domain) {
		return TipoFrecuenciaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoFrecuenciaDomain toDomainFromDto(TipoFrecuenciaDTO dto) {
		return new TipoFrecuenciaDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoFrecuenciaEntity toEntityFromDomain(TipoFrecuenciaDomain domain) {
		return new TipoFrecuenciaEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoFrecuenciaDomain toDomainFromEntity(TipoFrecuenciaEntity entity) {
		return new TipoFrecuenciaDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<TipoFrecuenciaDomain> toDomainListFromEntityList(List<TipoFrecuenciaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<TipoFrecuenciaDTO> toDTOListFromDomainList(List<TipoFrecuenciaDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
