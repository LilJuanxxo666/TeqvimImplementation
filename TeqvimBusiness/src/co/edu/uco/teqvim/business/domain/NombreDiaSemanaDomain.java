package co.edu.uco.teqvim.business.domain;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class NombreDiaSemanaDomain {
	
	private static final NombreDiaSemanaDomain DEFAULT_OBJECT = new NombreDiaSemanaDomain();
	private UUID identificador;
	private String nombre;
	private String apodo;
	
	private NombreDiaSemanaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setApodo(UtilText.EMPTY);
	}
	
	public NombreDiaSemanaDomain(UUID identificador, String nombre, String apodo) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setApodo(apodo);
	}
	
	public static NombreDiaSemanaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
	}

	public final String getApodo() {
		return apodo;
	}

	public final void setApodo(final String apodo) {
		this.apodo = UtilText.getUtilText().applyTrim(apodo);
	}
	
	
}
