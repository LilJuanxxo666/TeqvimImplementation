package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.EstadoPeriodoAcademicoDomain;
import co.edu.uco.teqvim.dto.EstadoPeriodoAcademicoDTO;
import co.edu.uco.teqvim.entities.EstadoPeriodoAcademicoEntity;

public class EstadoPeriodoAcademicoAssembler
		implements Assembler<EstadoPeriodoAcademicoDomain, EstadoPeriodoAcademicoDTO, EstadoPeriodoAcademicoEntity> {
	private static final Assembler<EstadoPeriodoAcademicoDomain, EstadoPeriodoAcademicoDTO, EstadoPeriodoAcademicoEntity> INSTANCE = new EstadoPeriodoAcademicoAssembler();

	private EstadoPeriodoAcademicoAssembler() {
		super();
	}

	public static Assembler<EstadoPeriodoAcademicoDomain, EstadoPeriodoAcademicoDTO, EstadoPeriodoAcademicoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public EstadoPeriodoAcademicoDTO toDtoFromDomain(EstadoPeriodoAcademicoDomain domain) {
		return EstadoPeriodoAcademicoDTO.create().setIdentificador(domain.getIdentificador())
				.setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}

	@Override
	public EstadoPeriodoAcademicoDomain toDomainFromDto(EstadoPeriodoAcademicoDTO dto) {
		return new EstadoPeriodoAcademicoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoPeriodoAcademicoEntity toEntityFromDomain(EstadoPeriodoAcademicoDomain domain) {
		return new EstadoPeriodoAcademicoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public EstadoPeriodoAcademicoDomain toDomainFromEntity(EstadoPeriodoAcademicoEntity entity) {
		return new EstadoPeriodoAcademicoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<EstadoPeriodoAcademicoDomain> toDomainListFromEntityList(
			List<EstadoPeriodoAcademicoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<EstadoPeriodoAcademicoDTO> toDTOListFromDomainList(List<EstadoPeriodoAcademicoDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
