package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.MateriaDomain;
import co.edu.uco.teqvim.dto.MateriaDTO;
import co.edu.uco.teqvim.entities.MateriaEntity;

public class MateriaAssembler implements Assembler<MateriaDomain, MateriaDTO, MateriaEntity> {

	private static final Assembler<MateriaDomain, MateriaDTO, MateriaEntity> INSTANCE = new MateriaAssembler();

	private MateriaAssembler() {
		super();
	}

	public static Assembler<MateriaDomain, MateriaDTO, MateriaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public MateriaDTO toDtoFromDomain(MateriaDomain domain) {
		return MateriaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setCreditos(domain.getCreditos()).setPeriodoAcademico(
						PeriodoAcademicoAssembler.getInstance().toDtoFromDomain(domain.getPeriodoAcademico()));

	}

	@Override
	public MateriaDomain toDomainFromDto(MateriaDTO dto) {
		return new MateriaDomain(dto.getIdentificador(), dto.getNombre(), dto.getCreditos(),
				PeriodoAcademicoAssembler.getInstance().toDomainFromDto(dto.getPeriodoAcademico()));
	}

	@Override
	public MateriaEntity toEntityFromDomain(MateriaDomain domain) {
		return new MateriaEntity(domain.getIdentificador(), domain.getNombre(), domain.getCreditos(),
				PeriodoAcademicoAssembler.getInstance().toEntityFromDomain(domain.getPeriodoAcademico()));
	}

	@Override
	public MateriaDomain toDomainFromEntity(MateriaEntity entity) {
		return new MateriaDomain(entity.getIdentificador(), entity.getNombre(), entity.getCreditos(),
				PeriodoAcademicoAssembler.getInstance().toDomainFromEntity(entity.getPeriodoAcademico()));
	}

	@Override
	public List<MateriaDomain> toDomainListFromEntityList(List<MateriaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<MateriaDTO> toDTOListFromDomainList(List<MateriaDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
