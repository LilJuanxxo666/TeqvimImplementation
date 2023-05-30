package co.edu.uco.teqvim.dto;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class DuracionDTO {

	private UUID identificador;
	private int cantidadTiempo;
	private UnidadTiempoDTO unidadTiempo;
	
	public DuracionDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCantidadTiempo(UtilNumber.ZERO.hashCode());
		setUnidadTiempo(UnidadTiempoDTO.create());
	}

	public DuracionDTO(final UUID identificador, final int cantidadTiempo, final UnidadTiempoDTO unidadTiempo) {
		super();
		setIdentificador(identificador);
		setCantidadTiempo(cantidadTiempo);
		setUnidadTiempo(unidadTiempo);
	}
	
	public static DuracionDTO create() {
		return new DuracionDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final DuracionDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final int getCantidadTiempo() {
		return cantidadTiempo;
	}

	public final DuracionDTO setCantidadTiempo(final int cantidadTiempo) {
		this.cantidadTiempo = UtilNumber.getUtilNumber().getDefault(cantidadTiempo).intValue();
		return this;
	}

	public final UnidadTiempoDTO getUnidadTiempo() {
		return unidadTiempo;
	}

	public final DuracionDTO setUnidadTiempo(final UnidadTiempoDTO unidadTiempo) {
		this.unidadTiempo = UtilObject.getDefault(unidadTiempo, UnidadTiempoDTO.create());
		return this;
	}

}
