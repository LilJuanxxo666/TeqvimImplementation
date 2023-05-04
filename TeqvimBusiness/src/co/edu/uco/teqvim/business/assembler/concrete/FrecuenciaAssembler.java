package co.edu.uco.teqvim.business.assembler.concrete;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.FrecuenciaDomain;
import co.edu.uco.teqvim.dto.FrecuenciaDTO;
import co.edu.uco.teqvim.entities.FrecuenciaEntity;

public final class FrecuenciaAssembler implements Assembler<FrecuenciaDomain, FrecuenciaDTO, FrecuenciaEntity> {
	
	private static final Assembler<FrecuenciaDomain, FrecuenciaDTO, FrecuenciaEntity> INSTANCE = new FrecuenciaAssembler();

	private FrecuenciaAssembler() {
		super();
	}

	public static Assembler<FrecuenciaDomain, FrecuenciaDTO, FrecuenciaEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public FrecuenciaDTO toDtoFromDomain(FrecuenciaDomain domain) {
		return FrecuenciaDTO.create().setIdentificador(domain.getIdentificador()).setIntervalo(domain.getIntervalo())
				.setTipoFrecuencia(TipoFrecuenciaAssembler.getInstance().toDtoFromDomain(domain.getTipoFrecuencia()));
	}

	@Override
	public FrecuenciaDomain toDomainFromDto(FrecuenciaDTO dto) {
		return new FrecuenciaDomain(dto.getIdentificador(), dto.getIntervalo(),
				TipoFrecuenciaAssembler.getInstance().toDomainFromDto(dto.getTipoFrecuencia()));
	}

	@Override
	public FrecuenciaEntity toEntityFromDomain(FrecuenciaDomain domain) {
		return new FrecuenciaEntity(domain.getIdentificador(), domain.getIntervalo(),
				TipoFrecuenciaAssembler.getInstance().toEntityFromDomain(domain.getTipoFrecuencia()));
	}

	@Override
	public FrecuenciaDomain toDomainFromEntity(FrecuenciaEntity entity) {
		return new FrecuenciaDomain(entity.getIdentificador(), entity.getIntervalo(),
				TipoFrecuenciaAssembler.getInstance().toDomainFromEntity(entity.getTipoFrecuencia()));
	}

}
