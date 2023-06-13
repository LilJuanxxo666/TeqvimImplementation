package co.edu.uco.teqvim.entities;

import java.util.UUID;


import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class MateriaEntity {

	private UUID identificador;
	private String nombre;
	private int creditos;
	private Double promedioMateria;
	private PeriodoAcademicoEntity periodoAcademico;

	private MateriaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setCreditos(UtilNumber.ZERO.intValue());
		setPeriodoAcademico(PeriodoAcademicoEntity.create());
		setPromedioMateria(UtilNumber.ZERO.doubleValue());
	}

	public MateriaEntity(UUID identificador, String nombre, int creditos, PeriodoAcademicoEntity periodoAcademico, Double promedioMateria) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setCreditos(creditos);
		setPeriodoAcademico(periodoAcademico);
		setPromedioMateria(promedioMateria);

	}

	public static MateriaEntity create() {
		return new MateriaEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final MateriaEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final MateriaEntity setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final int getCreditos() {
		return creditos;
	}

	public final MateriaEntity setCreditos(final int creditos) {
		this.creditos = UtilNumber.getUtilNumber().getDefault(creditos).intValue();
		return this;
	}

	public final PeriodoAcademicoEntity getPeriodoAcademico() {
		return periodoAcademico;
	}

	public final MateriaEntity setPeriodoAcademico(final PeriodoAcademicoEntity periodoAcademico) {
		this.periodoAcademico = UtilObject.getDefault(periodoAcademico, PeriodoAcademicoEntity.create());
		return this;
	}
	public final Double getPromedioMateria() {
		return promedioMateria;
	}

	public final MateriaEntity setPromedioMateria(Double promedioMateria) {
		this.promedioMateria = UtilNumber.getUtilNumber().getDefault(promedioMateria).doubleValue();
		return this;
	}
}
