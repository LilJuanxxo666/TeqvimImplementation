package co.edu.uco.teqvim.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class PeriodoAcademicoDTO {

	private UUID identificador;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private TipoPeriodoAcademicoDTO tipoPeriodo;
	private EstadoPeriodoAcademicoDTO estado;
	private EstudianteDTO estudiante;

	public PeriodoAcademicoDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setFechaInicio(UtilDate.DEFAULT_DATE);
		setFechaFin(UtilDate.DEFAULT_DATE);
		setTipoPeriodo(TipoPeriodoAcademicoDTO.create());
		setEstado(EstadoPeriodoAcademicoDTO.create());
		setEstudiante(EstudianteDTO.create());
	}

	public PeriodoAcademicoDTO(UUID identificador, String nombre, LocalDate fechaInicio, LocalDate fechaFin,
			TipoPeriodoAcademicoDTO tipoPeriodo, EstadoPeriodoAcademicoDTO estado, EstudianteDTO estudiante) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setTipoPeriodo(tipoPeriodo);
		setEstado(estado);
		setEstudiante(estudiante);
	}

	public static PeriodoAcademicoDTO create() {
		return new PeriodoAcademicoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final PeriodoAcademicoDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final PeriodoAcademicoDTO setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public final PeriodoAcademicoDTO setFechaInicio(final LocalDate fechaInicio) {
		this.fechaInicio = UtilDate.getDefault(fechaInicio);
		return this;
	}

	public final LocalDate getFechaFin() {
		return fechaFin;
	}

	public final PeriodoAcademicoDTO setFechaFin(final LocalDate fechaFin) {
		this.fechaFin = UtilDate.getDefault(fechaFin);
		return this;
	}

	public final TipoPeriodoAcademicoDTO getTipoPeriodo() {
		return tipoPeriodo;
	}

	public final PeriodoAcademicoDTO setTipoPeriodo(final TipoPeriodoAcademicoDTO tipoPeriodo) {
		this.tipoPeriodo = UtilObject.getDefault(tipoPeriodo, TipoPeriodoAcademicoDTO.create());
		return this;
	}

	public final EstadoPeriodoAcademicoDTO getEstado() {
		return estado;
	}

	public final PeriodoAcademicoDTO setEstado(final EstadoPeriodoAcademicoDTO estado) {
		this.estado = UtilObject.getDefault(estado, EstadoPeriodoAcademicoDTO.create());
		return this;
	}

	public final EstudianteDTO getEstudiante() {
		return estudiante;
	}

	public final PeriodoAcademicoDTO setEstudiante(EstudianteDTO estudiante) {
		this.estudiante = UtilObject.getDefault(estudiante, EstudianteDTO.create());
		return this;
	}
}
