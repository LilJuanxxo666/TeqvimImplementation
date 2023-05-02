package co.edu.uco.teqvim.dto;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class UnidadTiempoDTO {

	private UUID identificador;
	private String nombre;
	
	public UnidadTiempoDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
	}

	public UnidadTiempoDTO(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
	}
	
	public static UnidadTiempoDTO create() {
		return new UnidadTiempoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final UnidadTiempoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final UnidadTiempoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
