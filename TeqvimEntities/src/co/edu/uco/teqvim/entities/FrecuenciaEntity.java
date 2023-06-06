package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class FrecuenciaEntity {
	
	private UUID identificador;
	private int intervalo;
	private TipoFrecuenciaEntity tipoFrecuencia;
	
	private FrecuenciaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setIntervalo(UtilNumber.ZERO.intValue());
		setTipoFrecuencia(TipoFrecuenciaEntity.create());
	}

	public FrecuenciaEntity(UUID identificador, int intervalo, TipoFrecuenciaEntity tipoFrecuencia) {
		super();
		setIdentificador(identificador);
		setIntervalo(intervalo);
		setTipoFrecuencia(tipoFrecuencia);
	}
	
	public static FrecuenciaEntity create() {
		return new FrecuenciaEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final FrecuenciaEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final int getIntervalo() {
		return intervalo;
	}

	public final FrecuenciaEntity setIntervalo(final int intervalo) {
		this.intervalo = UtilNumber.getUtilNumber().getDefault(intervalo).intValue();
		return this;
	}

	public final TipoFrecuenciaEntity getTipoFrecuencia() {
		return tipoFrecuencia;
	}

	public final FrecuenciaEntity setTipoFrecuencia(final TipoFrecuenciaEntity tipoFrecuencia) {
		this.tipoFrecuencia = UtilObject.getDefault(tipoFrecuencia, TipoFrecuenciaEntity.create());
		return this;
	}

}
