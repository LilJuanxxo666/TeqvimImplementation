package co.edu.uco.teqvim.business.assembler.concrete;

import java.util.List;

import co.edu.uco.teqvim.business.assembler.Assembler;
import co.edu.uco.teqvim.business.domain.FestivoDomain;
import co.edu.uco.teqvim.dto.FestivoDTO;
import co.edu.uco.teqvim.entities.FestivoEntity;

public class FestivoAssembler implements Assembler<FestivoDomain, FestivoDTO, FestivoEntity> {

	private static final Assembler<FestivoDomain, FestivoDTO, FestivoEntity> INSTANCE = new FestivoAssembler();

	private FestivoAssembler() {
		super();
	}

	public static Assembler<FestivoDomain, FestivoDTO, FestivoEntity> getInstance() {
		return INSTANCE;
	}

	@Override
	public FestivoDTO toDtoFromDomain(FestivoDomain domain) {
		return FestivoDTO.create().setIdentificador(domain.getIdentificador()).setFecha(domain.getFecha())
				.setFestividad(domain.getFestividad())
				.setTipo(TipoFestivoAssembler.getInstance().toDtoFromDomain(domain.getTipo()))
				.setTipoFijo(TipoFestivoFijoAssembler.getInstance().toDtoFromDomain(domain.getTipoFijo()))
				.setPaisCelebracion(PaisAssembler.getInstance().toDtoFromDomain(domain.getPaisCelebracion()));
	}

	@Override
	public FestivoDomain toDomainFromDto(FestivoDTO dto) {
		return new FestivoDomain(dto.getIdentificador(),
				TipoFestivoAssembler.getInstance().toDomainFromDto(dto.getTipo()),
				TipoFestivoFijoAssembler.getInstance().toDomainFromDto(dto.getTipoFijo()), dto.getFecha(),
				dto.getFestividad(), PaisAssembler.getInstance().toDomainFromDto(dto.getPaisCelebracion()));
	}

	@Override
	public FestivoEntity toEntityFromDomain(FestivoDomain domain) {
		return new FestivoEntity(domain.getIdentificador(),
				TipoFestivoAssembler.getInstance().toEntityFromDomain(domain.getTipo()),
				TipoFestivoFijoAssembler.getInstance().toEntityFromDomain(domain.getTipoFijo()), domain.getFecha(),
				domain.getFestividad(), PaisAssembler.getInstance().toEntityFromDomain(domain.getPaisCelebracion()));
	}

	@Override
	public FestivoDomain toDomainFromEntity(FestivoEntity entity) {
		return new FestivoDomain(entity.getIdentificador(),
				TipoFestivoAssembler.getInstance().toDomainFromEntity(entity.getTipo()),
				TipoFestivoFijoAssembler.getInstance().toDomainFromEntity(entity.getTipoFijo()), entity.getFecha(),
				entity.getFestividad(), PaisAssembler.getInstance().toDomainFromEntity(entity.getPaisCelebracion()));
	}

	@Override
	public List<FestivoDomain> toDomainListFromEntityList(List<FestivoEntity> entityList) {
		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
	}

	@Override
	public List<FestivoDTO> toDTOListFromDomainList(List<FestivoDomain> domainList) {
		return domainList.stream().map(domain -> toDtoFromDomain(domain)).toList();
	}

}
