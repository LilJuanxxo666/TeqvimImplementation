package co.edu.uco.teqvim.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class PeriodoAcademicoEntity {

	private static final PeriodoAcademicoEntity DEFAULT_OBJECT = new PeriodoAcademicoEntity();
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
		setTipoPeriodo(TipoPeriodoAcademicoEntity.getDefaultObject());
		setEstado(EstadoPeriodoAcademicoEntity.getDefaultObject());
		setEstudiante(EstudianteEntity.getDefaultObject());
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

	public static PeriodoAcademicoEntity getDefaultObject() {
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

	public final LocalDate getFechaInicio() {
		return fechaInicio;
	}

	private final void setFechaInicio(final LocalDate fechaInicio) {
		this.fechaInicio = UtilDate.getDefault(fechaInicio);
	}

	public final LocalDate getFechaFin() {
		return fechaFin;
	}

	private final void setFechaFin(final LocalDate fechaFin) {
		this.fechaFin = UtilDate.getDefault(fechaFin);
	}

	public final TipoPeriodoAcademicoEntity getTipoPeriodo() {
		return tipoPeriodo;
	}

	private final void setTipoPeriodo(final TipoPeriodoAcademicoEntity tipoPeriodo) {
		this.tipoPeriodo = UtilObject.getDefault(tipoPeriodo, TipoPeriodoAcademicoEntity.getDefaultObject());
	}

	public final EstadoPeriodoAcademicoEntity getEstado() {
		return estado;
	}

	private final void setEstado(final EstadoPeriodoAcademicoEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoPeriodoAcademicoEntity.getDefaultObject());
	}

	public final EstudianteEntity getEstudiante() {
		return estudiante;
	}

	private final PeriodoAcademicoEntity setEstudiante(EstudianteEntity estudiante) {
		this.estudiante = UtilObject.getDefault(estudiante, EstudianteEntity.getDefaultObject());
		return this;
	}
}
