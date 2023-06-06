package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class DiaSemanaEntity {
	
	private UUID identificador;
	private NombreDiaSemanaEntity nombreDiaSemana;
	private RepeticionEntity repeticion;
	
	private DiaSemanaEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombreDiaSemana(NombreDiaSemanaEntity.create());
		setRepeticion(RepeticionEntity.getDefaultObject());
	}
	
	public DiaSemanaEntity(UUID identificador, NombreDiaSemanaEntity nombreDiaSemana, RepeticionEntity repeticion) {
		setIdentificador(identificador);
		setNombreDiaSemana(nombreDiaSemana);
		setRepeticion(repeticion);
	}
	
	public static DiaSemanaEntity create() {
		return new DiaSemanaEntity();
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	public final DiaSemanaEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}
	public final NombreDiaSemanaEntity getNombreDiaSemana() {
		return nombreDiaSemana;
	}
	public final DiaSemanaEntity setNombreDiaSemana(NombreDiaSemanaEntity nombreDiaSemana) {
		this.nombreDiaSemana = UtilObject.getDefault(nombreDiaSemana, NombreDiaSemanaEntity.create());
		return this;
	}
	public final RepeticionEntity getRepeticion() {
		return repeticion;
	}
	public final DiaSemanaEntity setRepeticion(RepeticionEntity repeticion) {
		this.repeticion = UtilObject.getDefault(repeticion, RepeticionEntity.getDefaultObject());
		return this;
	}
}
