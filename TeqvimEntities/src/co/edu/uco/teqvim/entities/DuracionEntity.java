package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class DuracionEntity {
	
	private UUID identificador;
	private int cantidadTiempo;
	private UnidadTiempoEntity unidadTiempo;
	
	private DuracionEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCantidadTiempo(UtilNumber.ZERO.intValue());
		setUnidadTiempo(UnidadTiempoEntity.create());
	}

	public DuracionEntity(final UUID identificador, final int cantidadTiempo, final UnidadTiempoEntity unidadTiempo) {
		super();
		setIdentificador(identificador);
		setCantidadTiempo(cantidadTiempo);
		setUnidadTiempo(unidadTiempo);
	}
	
	public static DuracionEntity create() {
		return new DuracionEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final DuracionEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final int getCantidadTiempo() {
		return cantidadTiempo;
	}

	public final DuracionEntity setCantidadTiempo(final int cantidadTiempo) {
		this.cantidadTiempo = UtilNumber.getUtilNumber().getDefault(cantidadTiempo).intValue();
		return this;
	}

	public final UnidadTiempoEntity getUnidadTiempo() {
		return unidadTiempo;
	}

	public final DuracionEntity setUnidadTiempo(final UnidadTiempoEntity unidadTiempo) {
		this.unidadTiempo = UtilObject.getDefault(unidadTiempo, UnidadTiempoEntity.create());
		return this;
	}

}
