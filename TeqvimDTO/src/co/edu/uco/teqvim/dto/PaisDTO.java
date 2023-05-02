package co.edu.uco.teqvim.dto;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class PaisDTO {

	private UUID identificador;
	private String nombre;
	
	public PaisDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
	}

	public PaisDTO(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
	}
	
	public static PaisDTO create() {
		return new PaisDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final PaisDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final PaisDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
