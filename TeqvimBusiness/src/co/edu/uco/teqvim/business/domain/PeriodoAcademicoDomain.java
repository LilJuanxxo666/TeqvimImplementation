package co.edu.uco.teqvim.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class PeriodoAcademicoDomain {

	private static final PeriodoAcademicoDomain DEFAULT_OBJECT = new PeriodoAcademicoDomain();
	private UUID identificador;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private TipoPeriodoAcademicoDomain tipoPeriodo;
	private EstadoPeriodoAcademicoDomain estado;

	private PeriodoAcademicoDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setFechaInicio(UtilDate.DEFAULT_DATE);
		setFechaFin(UtilDate.DEFAULT_DATE);
		setTipoPeriodo(TipoPeriodoAcademicoDomain.getDefaultObject());
		setEstado(EstadoPeriodoAcademicoDomain.getDefaultObject());
	}

	public PeriodoAcademicoDomain(UUID identificador, String nombre, LocalDate fechaInicio, LocalDate fechaFin,
			TipoPeriodoAcademicoDomain tipoPeriodo, EstadoPeriodoAcademicoDomain estado) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setTipoPeriodo(tipoPeriodo);
		setEstado(estado);
	}

	public static PeriodoAcademicoDomain getDefaultObject() {
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

	public final TipoPeriodoAcademicoDomain getTipoPeriodo() {
		return tipoPeriodo;
	}

	private final void setTipoPeriodo(final TipoPeriodoAcademicoDomain tipoPeriodo) {
		this.tipoPeriodo = UtilObject.getDefault(tipoPeriodo, TipoPeriodoAcademicoDomain.getDefaultObject());
	}

	public final EstadoPeriodoAcademicoDomain getEstado() {
		return estado;
	}

	private final void setEstado(final EstadoPeriodoAcademicoDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoPeriodoAcademicoDomain.getDefaultObject());
	}

}
