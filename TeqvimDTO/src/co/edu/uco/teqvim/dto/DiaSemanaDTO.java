package co.edu.uco.teqvim.dto;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class DiaSemanaDTO {
	
	private UUID identificador;
	private NombreDiaSemanaDTO nombreDiaSemana;
	private RepeticionDTO repeticion;
	
	public DiaSemanaDTO() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombreDiaSemana(NombreDiaSemanaDTO.create());
		setRepeticion(RepeticionDTO.create());
	}
	
	public DiaSemanaDTO(UUID identificador, NombreDiaSemanaDTO nombreDiaSemana, RepeticionDTO repeticion) {
		setIdentificador(identificador);
		setNombreDiaSemana(nombreDiaSemana);
		setRepeticion(repeticion);
	}
	
	public static DiaSemanaDTO create() {
		return new DiaSemanaDTO();
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	public final DiaSemanaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}
	public final NombreDiaSemanaDTO getNombreDiaSemana() {
		return nombreDiaSemana;
	}
	public final DiaSemanaDTO setNombreDiaSemana(NombreDiaSemanaDTO nombreDiaSemana) {
		this.nombreDiaSemana = UtilObject.getDefault(nombreDiaSemana, NombreDiaSemanaDTO.create());
		return this;
	}
	public final RepeticionDTO getRepeticion() {
		return repeticion;
	}
	public final DiaSemanaDTO setRepeticion(RepeticionDTO repeticion) {
		this.repeticion = UtilObject.getDefault(repeticion, RepeticionDTO.create());
		return this;
	}
}
