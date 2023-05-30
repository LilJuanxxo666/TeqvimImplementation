package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class DuracionEntity {
	
	private static final DuracionEntity DEFAULT_OBJECT = new DuracionEntity();
	private UUID identificador;
	private int cantidadTiempo;
	private UnidadTiempoEntity unidadTiempo;
	
	private DuracionEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCantidadTiempo(UtilNumber.ZERO.intValue());
		setUnidadTiempo(UnidadTiempoEntity.getDefaultObject());
	}

	public DuracionEntity(final UUID identificador, final int cantidadTiempo, final UnidadTiempoEntity unidadTiempo) {
		super();
		setIdentificador(identificador);
		setCantidadTiempo(cantidadTiempo);
		setUnidadTiempo(unidadTiempo);
	}
	
	public static DuracionEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final DuracionEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final int getCantidadTiempo() {
		return cantidadTiempo;
	}

	private final DuracionEntity setCantidadTiempo(final int cantidadTiempo) {
		this.cantidadTiempo = UtilNumber.getUtilNumber().getDefault(cantidadTiempo).intValue();
		return this;
	}

	public final UnidadTiempoEntity getUnidadTiempo() {
		return unidadTiempo;
	}

	private final DuracionEntity setUnidadTiempo(final UnidadTiempoEntity unidadTiempo) {
		this.unidadTiempo = UtilObject.getDefault(unidadTiempo, UnidadTiempoEntity.getDefaultObject());
		return this;
	}

}
