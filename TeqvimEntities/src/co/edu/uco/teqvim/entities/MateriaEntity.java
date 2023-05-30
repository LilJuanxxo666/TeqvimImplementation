package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class MateriaEntity {

	private static final MateriaEntity DEFAULT_OBJECT = new MateriaEntity();
	private UUID identificador;
	private String nombre;
	private int creditos;
	private PeriodoAcademicoEntity periodoAcademico;

	private MateriaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setCreditos(UtilNumber.ZERO.intValue());
		setPeriodoAcademico(PeriodoAcademicoEntity.getDefaultObject());
	}

	public MateriaEntity(UUID identificador, String nombre, int creditos, PeriodoAcademicoEntity periodoAcademico) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setCreditos(creditos);
		setPeriodoAcademico(periodoAcademico);

	}

	public static MateriaEntity getDefaultObject() {
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

	public final PeriodoAcademicoEntity getPeriodoAcademico() {
		return periodoAcademico;
	}

	private final void setPeriodoAcademico(final PeriodoAcademicoEntity periodoAcademico) {
		this.periodoAcademico = UtilObject.getDefault(periodoAcademico, PeriodoAcademicoEntity.getDefaultObject());
	}

}
