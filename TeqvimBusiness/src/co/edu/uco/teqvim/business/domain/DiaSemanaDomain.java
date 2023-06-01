package co.edu.uco.teqvim.business.domain;

import java.util.UUID;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class DiaSemanaDomain {
	
	private static final DiaSemanaDomain DEFAULT_OBJECT = new DiaSemanaDomain();
	private UUID identificador;
	private NombreDiaSemanaDomain nombreDiaSemana;
	private RepeticionDomain repeticion;
	
	private DiaSemanaDomain() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombreDiaSemana(NombreDiaSemanaDomain.getDefaultObject());
		setRepeticion(RepeticionDomain.getDefaultObject());
	}
	
	public DiaSemanaDomain(UUID identificador, NombreDiaSemanaDomain nombreDiaSemana, RepeticionDomain repeticion) {
		setIdentificador(identificador);
		setNombreDiaSemana(nombreDiaSemana);
		setRepeticion(repeticion);
	}
	
	public static DiaSemanaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}
	public final NombreDiaSemanaDomain getNombreDiaSemana() {
		return nombreDiaSemana;
	}
	private final void setNombreDiaSemana(NombreDiaSemanaDomain nombreDiaSemana) {
		this.nombreDiaSemana = UtilObject.getDefault(nombreDiaSemana, NombreDiaSemanaDomain.getDefaultObject());
	}
	
	public final RepeticionDomain getRepeticion() {
		return repeticion;
	}
	
	private final void setRepeticion(RepeticionDomain repeticion) {
		this.repeticion = UtilObject.getDefault(repeticion, RepeticionDomain.getDefaultObject());
	}
}
