package co.edu.uco.teqvim.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class EventoDomain {
	
	private static final EventoDomain DEFAULT_OBJECT = new EventoDomain();
	private UUID identificador;
	private String titulo;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private TipoDuracionEventoDomain duracionEvento;
	private EstadoEventoDomain estado;
	private TipoEventoDomain tipoEvento;
	private EstudianteDomain estudiante;
	
	private EventoDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTitulo(UtilText.EMPTY);
		setDescripcion(UtilText.EMPTY);
		setFechaInicio(UtilDate.DEFAULT_DATE);
		setFechaFin(UtilDate.DEFAULT_DATE);
		setDuracionEvento(TipoDuracionEventoDomain.getDefaultObject());
		setEstado(EstadoEventoDomain.getDefaultObject());
		setTipoEvento(TipoEventoDomain.getDefaultObject());
		setEstudiante(EstudianteDomain.getDefaultObject());
	}

	public EventoDomain(UUID identificador, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
			TipoDuracionEventoDomain duracionEvento, EstadoEventoDomain estado, TipoEventoDomain tipoEvento,
			EstudianteDomain estudiante) {
		super();
		setIdentificador(identificador);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setDuracionEvento(duracionEvento);
		setEstado(estado);
		setTipoEvento(tipoEvento);
		setEstudiante(estudiante);
	}
	
	public static EventoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final String getTitulo() {
		return titulo;
	}

	private final void setTitulo(final String titulo) {
		this.titulo = UtilText.getUtilText().applyTrim(titulo);
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
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

	public final TipoDuracionEventoDomain getDuracionEvento() {
		return duracionEvento;
	}

	private final void setDuracionEvento(final TipoDuracionEventoDomain duracionEvento) {
		this.duracionEvento = UtilObject.getDefault(duracionEvento, TipoDuracionEventoDomain.getDefaultObject());
	}

	public final EstadoEventoDomain getEstado() {
		return estado;
	}

	private final void setEstado(final EstadoEventoDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoEventoDomain.getDefaultObject());
	}

	public final TipoEventoDomain getTipoEvento() {
		return tipoEvento;
	}

	private final void setTipoEvento(final TipoEventoDomain tipoEvento) {
		this.tipoEvento = UtilObject.getDefault(tipoEvento, TipoEventoDomain.getDefaultObject());
	}

	public final EstudianteDomain getEstudiante() {
		return estudiante;
	}

	private final void setEstudiante(final EstudianteDomain estudiante) {
		this.estudiante = UtilObject.getDefault(estudiante, EstudianteDomain.getDefaultObject());
	}

}
