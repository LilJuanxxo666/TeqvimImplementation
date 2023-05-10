package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.RepeticionDomain;
import co.edu.uco.teqvim.dto.RepeticionDTO;
import co.edu.uco.teqvim.entities.RepeticionEntity;

public final class RepeticionAssembler implements Assembler<RepeticionDomain, RepeticionDTO, RepeticionEntity> {

	private static final Assembler<RepeticionDomain, RepeticionDTO, RepeticionEntity> INSTANCE = new RepeticionAssembler();

	private RepeticionAssembler() {
		super();
	}

	public static Assembler<RepeticionDomain, RepeticionDTO, RepeticionEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public RepeticionDTO toDtoFromDomain(RepeticionDomain domain) {
		return RepeticionDTO.create().setIdentificador(domain.getIdentificador())
				.setFrecuencia(FrecuenciaAssembler.getInstance().toDtoFromDomain(domain.getFrecuencia()))
				.setEvento(EventoAssembler.getInstance().toDtoFromDomain(domain.getEvento()))
				.setDiaSemana(domain.getDiaSemana())
				.setDuracion(DuracionAssembler.getInstance().toDtoFromDomain(domain.getDuracion()));
	}

	@Override
	public RepeticionDomain toDomainFromDto(RepeticionDTO dto) {
		return new RepeticionDomain(dto.getIdentificador(),
				EventoAssembler.getInstance().toDomainFromDto(dto.getEvento()),
				DuracionAssembler.getInstance().toDomainFromDto(dto.getDuracion()),
				FrecuenciaAssembler.getInstance().toDomainFromDto(dto.getFrecuencia()), dto.getDiaSemana());
	}

	@Override
	public RepeticionEntity toEntityFromDomain(RepeticionDomain domain) {
		return new RepeticionEntity(domain.getIdentificador(),
				EventoAssembler.getInstance().toEntityFromDomain(domain.getEvento()),
				DuracionAssembler.getInstance().toEntityFromDomain(domain.getDuracion()),
				FrecuenciaAssembler.getInstance().toEntityFromDomain(domain.getFrecuencia()), domain.getDiaSemana());
	}

	@Override
	public RepeticionDomain toDomainFromEntity(RepeticionEntity entity) {
		return new RepeticionDomain(entity.getIdentificador(),
				EventoAssembler.getInstance().toDomainFromEntity(entity.getEvento()),
				DuracionAssembler.getInstance().toDomainFromEntity(entity.getDuracion()),
				FrecuenciaAssembler.getInstance().toDomainFromEntity(entity.getFrecuencia()), entity.getDiaSemana());
	}

	@Override
	public List<RepeticionDomain> toDomainListFromEntityList(List<RepeticionEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<RepeticionDTO> toDTOListFromDomainList(List<RepeticionDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
