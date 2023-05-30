package co.edu.uco.teqvim.dto;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class NombreDiaSemanaDTO {
	
	private UUID identificador;
	private String nombre;
	private String apodo;
	
	public NombreDiaSemanaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setApodo(UtilText.EMPTY);
	}
	
	public NombreDiaSemanaDTO(UUID identificador, String nombre, String apodo) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setApodo(apodo);
	}
	
	public static NombreDiaSemanaDTO create() {
		return new NombreDiaSemanaDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final NombreDiaSemanaDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final NombreDiaSemanaDTO setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getApodo() {
		return apodo;
	}

	public final NombreDiaSemanaDTO setApodo(final String apodo) {
		this.apodo = UtilText.getUtilText().applyTrim(apodo);
		return this;
	}
	
	
}
