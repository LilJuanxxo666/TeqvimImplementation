package co.edu.uco.teqvim.business.assembler.concrete;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.TipoPeriodoAcademicoDomain;
import co.edu.uco.teqvim.dto.TipoPeriodoAcademicoDTO;
import co.edu.uco.teqvim.entities.TipoPeriodoAcademicoEntity;

public class TipoPeriodoAcademicoAssembler
		implements Assembler<TipoPeriodoAcademicoDomain, TipoPeriodoAcademicoDTO, TipoPeriodoAcademicoEntity> {
	
	private static final Assembler<TipoPeriodoAcademicoDomain, TipoPeriodoAcademicoDTO, TipoPeriodoAcademicoEntity> INSTANCE = new TipoPeriodoAcademicoAssembler();

	private TipoPeriodoAcademicoAssembler() {
		super();
	}

	public static Assembler<TipoPeriodoAcademicoDomain, TipoPeriodoAcademicoDTO, TipoPeriodoAcademicoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoPeriodoAcademicoDTO toDtoFromDomain(TipoPeriodoAcademicoDomain domain) {
		return TipoPeriodoAcademicoDTO.create().setIdentificador(domain.getIdentificador()).
				setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoPeriodoAcademicoDomain toDomainFromDto(TipoPeriodoAcademicoDTO dto) {
		return new TipoPeriodoAcademicoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoPeriodoAcademicoEntity toEntityFromDomain(TipoPeriodoAcademicoDomain domain) {
		return new TipoPeriodoAcademicoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoPeriodoAcademicoDomain toDomainFromEntity(TipoPeriodoAcademicoEntity entity) {
		return new TipoPeriodoAcademicoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}
}
