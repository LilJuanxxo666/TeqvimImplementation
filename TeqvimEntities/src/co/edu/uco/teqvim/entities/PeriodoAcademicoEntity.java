package co.edu.uco.teqvim.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class PeriodoAcademicoEntity {

	private UUID identificador;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private TipoPeriodoAcademicoEntity tipoPeriodo;
	private EstadoPeriodoAcademicoEntity estado;
	private EstudianteEntity estudiante;

	private PeriodoAcademicoEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setFechaInicio(UtilDate.DEFAULT_DATE);
		setFechaFin(UtilDate.DEFAULT_DATE);
		setTipoPeriodo(TipoPeriodoAcademicoEntity.create());
		setEstado(EstadoPeriodoAcademicoEntity.create());
		setEstudiante(EstudianteEntity.create());
	}

	public PeriodoAcademicoEntity(UUID identificador, String nombre, LocalDate fechaInicio, LocalDate fechaFin,
			TipoPeriodoAcademicoEntity tipoPeriodo, EstadoPeriodoAcademicoEntity estado, EstudianteEntity estudiante) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setTipoPeriodo(tipoPeriodo);
		setEstado(estado);
		setEstudiante(estudiante);
	}

	public static PeriodoAcademicoEntity create() {
		return new PeriodoAcademicoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final PeriodoAcademicoEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final PeriodoAcademicoEntity setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public final PeriodoAcademicoEntity setFechaInicio(final LocalDate fechaInicio) {
		this.fechaInicio = UtilDate.getDefault(fechaInicio);
		return this;
	}

	public final LocalDate getFechaFin() {
		return fechaFin;
	}

	public final PeriodoAcademicoEntity setFechaFin(final LocalDate fechaFin) {
		this.fechaFin = UtilDate.getDefault(fechaFin);
		return this;
	}

	public final TipoPeriodoAcademicoEntity getTipoPeriodo() {
		return tipoPeriodo;
	}

	public final PeriodoAcademicoEntity setTipoPeriodo(final TipoPeriodoAcademicoEntity tipoPeriodo) {
		this.tipoPeriodo = UtilObject.getDefault(tipoPeriodo, TipoPeriodoAcademicoEntity.create());
		return this;
	}

	public final EstadoPeriodoAcademicoEntity getEstado() {
		return estado;
	}

	public final PeriodoAcademicoEntity setEstado(final EstadoPeriodoAcademicoEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoPeriodoAcademicoEntity.create());
		return this;
	}

	public final EstudianteEntity getEstudiante() {
		return estudiante;
	}

	public final PeriodoAcademicoEntity setEstudiante(EstudianteEntity estudiante) {
		this.estudiante = UtilObject.getDefault(estudiante, EstudianteEntity.create());
		return this;
	}
}
