package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.NombreDiaSemanaDomain;
import co.edu.uco.teqvim.dto.NombreDiaSemanaDTO;
import co.edu.uco.teqvim.entities.NombreDiaSemanaEntity;

public class NombreDiaSemanaAssembler
		implements Assembler<NombreDiaSemanaDomain, NombreDiaSemanaDTO, NombreDiaSemanaEntity> {

	private static final Assembler<NombreDiaSemanaDomain, NombreDiaSemanaDTO, NombreDiaSemanaEntity> INSTANCE = new NombreDiaSemanaAssembler();

	private NombreDiaSemanaAssembler() {
		super();
	}

	public static Assembler<NombreDiaSemanaDomain, NombreDiaSemanaDTO, NombreDiaSemanaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public NombreDiaSemanaDTO toDtoFromDomain(NombreDiaSemanaDomain domain) {
		return NombreDiaSemanaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setApodo(domain.getApodo());
	}

	@Override
	public NombreDiaSemanaDomain toDomainFromDto(NombreDiaSemanaDTO dto) {
		return new NombreDiaSemanaDomain(dto.getIdentificador(), dto.getNombre(), dto.getApodo());
	}

	@Override
	public NombreDiaSemanaEntity toEntityFromDomain(NombreDiaSemanaDomain domain) {
		return new NombreDiaSemanaEntity(domain.getIdentificador(), domain.getNombre(), domain.getApodo());
	}

	@Override
	public NombreDiaSemanaDomain toDomainFromEntity(NombreDiaSemanaEntity entity) {
		return new NombreDiaSemanaDomain(entity.getIdentificador(), entity.getNombre(), entity.getApodo());
	}

	@Override
	public List<NombreDiaSemanaDomain> toDomainListFromEntityList(List<NombreDiaSemanaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<NombreDiaSemanaDTO> toDTOListFromDomainList(List<NombreDiaSemanaDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
