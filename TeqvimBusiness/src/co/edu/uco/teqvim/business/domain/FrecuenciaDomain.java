package co.edu.uco.teqvim.business.domain;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class FrecuenciaDomain {
	
	private static final FrecuenciaDomain DEFAULT_OBJECT = new FrecuenciaDomain();
	private UUID identificador;
	private int intervalo;
	private TipoFrecuenciaDomain tipoFrecuencia;
	
	private FrecuenciaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setIntervalo(UtilNumber.ZERO.intValue());
		setTipoFrecuencia(TipoFrecuenciaDomain.getDefaultObject());
	}

	public FrecuenciaDomain(UUID identificador, int intervalo, TipoFrecuenciaDomain tipoFrecuencia) {
		super();
		setIdentificador(identificador);
		setIntervalo(intervalo);
		setTipoFrecuencia(tipoFrecuencia);
	}
	
	public static FrecuenciaDomain getDefaultObject() {
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

	public final TipoFrecuenciaDomain getTipoFrecuencia() {
		return tipoFrecuencia;
	}

	private final void setTipoFrecuencia(final TipoFrecuenciaDomain tipoFrecuencia) {
		this.tipoFrecuencia = UtilObject.getDefault(tipoFrecuencia, TipoFrecuenciaDomain.getDefaultObject());
	}

}
