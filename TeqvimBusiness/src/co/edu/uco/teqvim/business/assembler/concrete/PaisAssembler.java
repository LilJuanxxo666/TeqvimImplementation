package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.PaisDomain;
import co.edu.uco.teqvim.dto.PaisDTO;
import co.edu.uco.teqvim.entities.PaisEntity;

public class PaisAssembler implements Assembler<PaisDomain, PaisDTO, PaisEntity> {
	private static final Assembler<PaisDomain, PaisDTO, PaisEntity> INSTANCE = new PaisAssembler();

	private PaisAssembler() {
		super();
	}

	public static Assembler<PaisDomain, PaisDTO, PaisEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public PaisDTO toDtoFromDomain(PaisDomain domain) {
		return PaisDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre());
	}

	@Override
	public PaisDomain toDomainFromDto(PaisDTO dto) {
		return new PaisDomain(dto.getIdentificador(), dto.getNombre());
	}

	@Override
	public PaisEntity toEntityFromDomain(PaisDomain domain) {
		return new PaisEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public PaisDomain toDomainFromEntity(PaisEntity entity) {
		return new PaisDomain(entity.getIdentificador(), entity.getNombre());
	}

	@Override
	public List<PaisDomain> toDomainListFromEntityList(List<PaisEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<PaisDTO> toDTOListFromDomainList(List<PaisDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}
}
