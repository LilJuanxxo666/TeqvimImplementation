package co.edu.uco.teqvim.business.domain;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class DuracionDomain {
	
	private static final DuracionDomain DEFAULT_OBJECT = new DuracionDomain();
	private UUID identificador;
	private int cantidadTiempo;
	private UnidadTiempoDomain unidadTiempo;
	
	private DuracionDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCantidadTiempo(UtilNumber.ZERO_INT);
		setUnidadTiempo(UnidadTiempoDomain.getDefaultObject());
	}

	public DuracionDomain(final UUID identificador, final int cantidadTiempo, final UnidadTiempoDomain unidadTiempo) {
		super();
		setIdentificador(identificador);
		setCantidadTiempo(cantidadTiempo);
		setUnidadTiempo(unidadTiempo);
	}
	
	public static DuracionDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final DuracionDomain setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final int getCantidadTiempo() {
		return cantidadTiempo;
	}

	public final DuracionDomain setCantidadTiempo(final int cantidadTiempo) {
		this.cantidadTiempo = cantidadTiempo;
		return this;
	}

	public final UnidadTiempoDomain getUnidadTiempo() {
		return unidadTiempo;
	}

	public final DuracionDomain setUnidadTiempo(final UnidadTiempoDomain unidadTiempo) {
		this.unidadTiempo = UtilObject.getDefault(unidadTiempo, UnidadTiempoDomain.getDefaultObject());
		return this;
	}

}
