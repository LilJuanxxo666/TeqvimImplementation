package co.edu.uco.teqvim.dto;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class MateriaDTO {

	private UUID identificador;
	private String nombre;
	private int creditos;
	private Double promedioMateria;
	private PeriodoAcademicoDTO periodoAcademico;

	public MateriaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setCreditos(UtilNumber.ZERO.intValue());
		setPeriodoAcademico(PeriodoAcademicoDTO.create());
	}

	public MateriaDTO(UUID identificador, String nombre, int creditos, PeriodoAcademicoDTO periodoAcademico) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setCreditos(creditos);
		setPeriodoAcademico(periodoAcademico);

	}

	public static MateriaDTO create() {
		return new MateriaDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final MateriaDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final MateriaDTO setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final int getCreditos() {
		return creditos;
	}

	public final MateriaDTO setCreditos(final int creditos) {
		this.creditos = UtilNumber.getUtilNumber().getDefault(creditos).intValue();
		return this;
	}

	public final PeriodoAcademicoDTO getPeriodoAcademico() {
		return periodoAcademico;
	}

	public final MateriaDTO setPeriodoAcademico(final PeriodoAcademicoDTO periodoAcademico) {
		this.periodoAcademico = UtilObject.getDefault(periodoAcademico, PeriodoAcademicoDTO.create());
		return this;
	}

	public final Double getPromedioMateria() {
		return promedioMateria;
	}

	public final MateriaDTO setPromedioMateria(Double promedioMateria) {
		this.promedioMateria = UtilNumber.getUtilNumber().getDefault(promedioMateria).doubleValue();
		return this;
	}
}
