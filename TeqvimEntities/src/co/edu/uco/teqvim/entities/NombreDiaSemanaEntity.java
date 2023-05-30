package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class NombreDiaSemanaEntity {
	
	private static final NombreDiaSemanaEntity DEFAULT_OBJECT = new NombreDiaSemanaEntity();
	private UUID identificador;
	private String nombre;
	private String apodo;
	
	private NombreDiaSemanaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setApodo(UtilText.EMPTY);
	}
	
	public NombreDiaSemanaEntity(UUID identificador, String nombre, String apodo) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setApodo(apodo);
	}
	
	public static NombreDiaSemanaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final NombreDiaSemanaEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	private final NombreDiaSemanaEntity setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getApodo() {
		return apodo;
	}

	private final NombreDiaSemanaEntity setApodo(final String apodo) {
		this.apodo = UtilText.getUtilText().applyTrim(apodo);
		return this;
	}
	
	
}
