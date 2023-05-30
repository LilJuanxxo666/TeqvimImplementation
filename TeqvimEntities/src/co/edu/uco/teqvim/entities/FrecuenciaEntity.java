package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class FrecuenciaEntity {
	
	private static final FrecuenciaEntity DEFAULT_OBJECT = new FrecuenciaEntity();
	private UUID identificador;
	private int intervalo;
	private TipoFrecuenciaEntity tipoFrecuencia;
	
	private FrecuenciaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setIntervalo(UtilNumber.ZERO.intValue());
		setTipoFrecuencia(TipoFrecuenciaEntity.getDefaultObject());
	}

	public FrecuenciaEntity(UUID identificador, int intervalo, TipoFrecuenciaEntity tipoFrecuencia) {
		super();
		setIdentificador(identificador);
		setIntervalo(intervalo);
		setTipoFrecuencia(tipoFrecuencia);
	}
	
	public static FrecuenciaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final int getIntervalo() {
		return intervalo;
	}

	private final void setIntervalo(final int intervalo) {
		this.intervalo = UtilNumber.getUtilNumber().getDefault(intervalo).intValue();
	}

	public final TipoFrecuenciaEntity getTipoFrecuencia() {
		return tipoFrecuencia;
	}

	private final void setTipoFrecuencia(final TipoFrecuenciaEntity tipoFrecuencia) {
		this.tipoFrecuencia = UtilObject.getDefault(tipoFrecuencia, TipoFrecuenciaEntity.getDefaultObject());
	}

}
