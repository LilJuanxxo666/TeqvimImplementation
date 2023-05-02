package co.edu.uco.teqvim.business.assembler;

public interface Assembler<D, T, E> {

	T toDtoFromDomain(D domain);

	D toDomainFromDto(T dto);

	E toEntityFromDomain(D domain);

	D toDomainFromEntity(E entity);
}
