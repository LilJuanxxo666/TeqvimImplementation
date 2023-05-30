package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class DiaSemanaEntity {
	
	private static final DiaSemanaEntity DEFAULT_OBJECT = new DiaSemanaEntity();
	private UUID identificador;
	private NombreDiaSemanaEntity nombreDiaSemana;
	private RepeticionEntity repeticion;
	
	private DiaSemanaEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombreDiaSemana(NombreDiaSemanaEntity.getDefaultObject());
		setRepeticion(RepeticionEntity.getDefaultObject());
	}
	
	public DiaSemanaEntity(UUID identificador, NombreDiaSemanaEntity nombreDiaSemana, RepeticionEntity repeticion) {
		setIdentificador(identificador);
		setNombreDiaSemana(nombreDiaSemana);
		setRepeticion(repeticion);
	}
	
	public static DiaSemanaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	private final DiaSemanaEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}
	public final NombreDiaSemanaEntity getNombreDiaSemana() {
		return nombreDiaSemana;
	}
	private final DiaSemanaEntity setNombreDiaSemana(NombreDiaSemanaEntity nombreDiaSemana) {
		this.nombreDiaSemana = UtilObject.getDefault(nombreDiaSemana, NombreDiaSemanaEntity.getDefaultObject());
		return this;
	}
	public final RepeticionEntity getRepeticion() {
		return repeticion;
	}
	private final DiaSemanaEntity setRepeticion(RepeticionEntity repeticion) {
		this.repeticion = UtilObject.getDefault(repeticion, RepeticionEntity.getDefaultObject());
		return this;
	}
}
