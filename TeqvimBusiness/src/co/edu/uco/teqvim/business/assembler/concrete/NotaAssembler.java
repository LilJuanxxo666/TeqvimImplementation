package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.NotaDomain;
import co.edu.uco.teqvim.dto.NotaDTO;
import co.edu.uco.teqvim.entities.NotaEntity;

public class NotaAssembler implements Assembler<NotaDomain, NotaDTO, NotaEntity> {

	private static final Assembler<NotaDomain, NotaDTO, NotaEntity> INSTANCE = new NotaAssembler();

	private NotaAssembler() {
		super();
	}

	public static Assembler<NotaDomain, NotaDTO, NotaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public NotaDTO toDtoFromDomain(NotaDomain domain) {
		return NotaDTO.create().setIdentificador(domain.getIdentificador())
				.setTipoNota(TipoNotaAssembler.getInstance().toDtoFromDomain(domain.getTipoNota()))
				.setCalificacion(domain.getCalificacion()).setDescripcion(domain.getDescripcion())
				.setMateria(MateriaAssembler.getInstance().toDtoFromDomain(domain.getMateria()));
	}

	@Override
	public NotaDomain toDomainFromDto(NotaDTO dto) {
		return new NotaDomain(dto.getIdentificador(),
				TipoNotaAssembler.getInstance().toDomainFromDto(dto.getTipoNota()), dto.getCalificacion(),
				dto.getDescripcion());
	}

	@Override
	public NotaEntity toEntityFromDomain(NotaDomain domain) {
		return new NotaEntity(domain.getIdentificador(),
				TipoNotaAssembler.getInstance().toEntityFromDomain(domain.getTipoNota()), domain.getCalificacion(),
				domain.getDescripcion());
	}

	@Override
	public NotaDomain toDomainFromEntity(NotaEntity entity) {
		return new NotaDomain(entity.getIdentificador(),
				TipoNotaAssembler.getInstance().toDomainFromEntity(entity.getTipoNota()), entity.getCalificacion(),
				entity.getDescripcion());
	}

	@Override
	public List<NotaDomain> toDomainListFromEntityList(List<NotaEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<NotaDTO> toDTOListFromDomainList(List<NotaDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
