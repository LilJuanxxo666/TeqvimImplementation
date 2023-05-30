package co.edu.uco.teqvim.business.domain;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class MateriaDomain {

	private static final MateriaDomain DEFAULT_OBJECT = new MateriaDomain();
	private UUID identificador;
	private String nombre;
	private int creditos;
	private PeriodoAcademicoDomain periodoAcademico;

	private MateriaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setCreditos(UtilNumber.ZERO.intValue());
		setPeriodoAcademico(PeriodoAcademicoDomain.getDefaultObject());
	}

	public MateriaDomain(UUID identificador, String nombre, int creditos, PeriodoAcademicoDomain periodoAcademico) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setCreditos(creditos);
		setPeriodoAcademico(periodoAcademico);

	}

	public static MateriaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);

	}

	public final int getCreditos() {
		return creditos;
	}

	private final void setCreditos(final int creditos) {
		this.creditos = UtilNumber.getUtilNumber().getDefault(creditos).intValue();
	}

	public final PeriodoAcademicoDomain getPeriodoAcademico() {
		return periodoAcademico;
	}

	private final void setPeriodoAcademico(final PeriodoAcademicoDomain periodoAcademico) {
		this.periodoAcademico = UtilObject.getDefault(periodoAcademico, PeriodoAcademicoDomain.getDefaultObject());
	}

}
