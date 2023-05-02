package co.edu.uco.teqvim.business.domain;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class UnidadTiempoDomain {
	
	private static final UnidadTiempoDomain DEFAULT_OBJECT = new UnidadTiempoDomain();
	private UUID identificador;
	private String nombre;
	
	private UnidadTiempoDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
	}

	public UnidadTiempoDomain(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
	}
	
	public static UnidadTiempoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
	}

}
