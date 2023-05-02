package co.edu.uco.teqvim.business.assembler.concrete;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.TipoDocumentoDomain;
import co.edu.uco.teqvim.dto.TipoDocumentoDTO;
import co.edu.uco.teqvim.entities.TipoDocumentoEntity;

public class TipoDocumentoAssembler implements Assembler<TipoDocumentoDomain, TipoDocumentoDTO, TipoDocumentoEntity>{
	
	private static final Assembler<TipoDocumentoDomain, TipoDocumentoDTO, TipoDocumentoEntity> INSTANCE = new TipoDocumentoAssembler();

	private TipoDocumentoAssembler() {
		super();
	}

	public static Assembler<TipoDocumentoDomain, TipoDocumentoDTO, TipoDocumentoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public TipoDocumentoDTO toDtoFromDomain(TipoDocumentoDomain domain) {
		return TipoDocumentoDTO.create().setIdentificador(domain.getIdentificador()).
				setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoDocumentoDomain toDomainFromDto(TipoDocumentoDTO dto) {
		return new TipoDocumentoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoDocumentoEntity toEntityFromDomain(TipoDocumentoDomain domain) {
		return new TipoDocumentoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoDocumentoDomain toDomainFromEntity(TipoDocumentoEntity entity) {
		return new TipoDocumentoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}
}
