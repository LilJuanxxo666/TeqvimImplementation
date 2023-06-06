package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class EstadoEstudianteEntity {

	private UUID identificador;
	private String nombre;
	private String descripcion;

	private EstadoEstudianteEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setDescripcion(UtilText.EMPTY);
	}

	public EstadoEstudianteEntity(UUID identificador, String nombre, String descripcion) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
	}

	public static EstadoEstudianteEntity create() {
		return new EstadoEstudianteEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final EstadoEstudianteEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final EstadoEstudianteEntity setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final EstadoEstudianteEntity setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

}
