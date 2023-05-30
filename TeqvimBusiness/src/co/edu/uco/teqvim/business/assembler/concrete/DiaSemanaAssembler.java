package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.DiaSemanaDomain;
import co.edu.uco.teqvim.dto.DiaSemanaDTO;
import co.edu.uco.teqvim.entities.DiaSemanaEntity;

public class DiaSemanaAssembler implements Assembler<DiaSemanaDomain, DiaSemanaDTO, DiaSemanaEntity> {
	

	private static final Assembler<DiaSemanaDomain, DiaSemanaDTO, DiaSemanaEntity> INSTANCE = new DiaSemanaAssembler();

	private DiaSemanaAssembler() {
		super();
	}

	public static Assembler<DiaSemanaDomain, DiaSemanaDTO, DiaSemanaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public DiaSemanaDTO toDtoFromDomain(final DiaSemanaDomain domain) {
		return DiaSemanaDTO.create().setIdentificador(domain.getIdentificador())
				.setNombreDiaSemana(NombreDiaSemanaAssembler.getInstance().toDtoFromDomain(domain.getNombreDiaSemana()))
				.setRepeticion(RepeticionAssembler.getInstance().toDtoFromDomain(domain.getRepeticion()));
	}

	@Override
	public DiaSemanaDomain toDomainFromDto(final DiaSemanaDTO dto) {
		return new DiaSemanaDomain(dto.getIdentificador(),
				NombreDiaSemanaAssembler.getInstance().toDomainFromDto(dto.getNombreDiaSemana()),
				RepeticionAssembler.getInstance().toDomainFromDto(dto.getRepeticion()));
	}

	@Override
	public DiaSemanaEntity toEntityFromDomain(final DiaSemanaDomain domain) {
		return new DiaSemanaEntity(domain.getIdentificador(),
				NombreDiaSemanaAssembler.getInstance().toEntityFromDomain(domain.getNombreDiaSemana()),
				RepeticionAssembler.getInstance().toEntityFromDomain(domain.getRepeticion()));
	}

	@Override
	public DiaSemanaDomain toDomainFromEntity(final DiaSemanaEntity entity) {
		return new DiaSemanaDomain(entity.getIdentificador(),
				NombreDiaSemanaAssembler.getInstance().toDomainFromEntity(entity.getNombreDiaSemana()),
				RepeticionAssembler.getInstance().toDomainFromEntity(entity.getRepeticion()));
	}

	@Override
	public List<DiaSemanaDomain> toDomainListFromEntityList(List<DiaSemanaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<DiaSemanaDTO> toDTOListFromDomainList(List<DiaSemanaDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
