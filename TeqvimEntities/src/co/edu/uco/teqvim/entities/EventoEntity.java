package co.edu.uco.teqvim.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class EventoEntity {
	
	private static final EventoEntity DEFAULT_OBJECT = new EventoEntity();
	private UUID identificador;
	private String titulo;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private TipoDuracionEventoEntity duracionEvento;
	private EstadoEventoEntity estado;
	private TipoEventoEntity tipoEvento;
	private EstudianteEntity estudiante;
	
	private EventoEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTitulo(UtilText.EMPTY);
		setDescripcion(UtilText.EMPTY);
		setFechaInicio(UtilDate.DEFAULT_DATE);
		setFechaFin(UtilDate.DEFAULT_DATE);
		setDuracionEvento(TipoDuracionEventoEntity.getDefaultObject());
		setEstado(EstadoEventoEntity.getDefaultObject());
		setTipoEvento(TipoEventoEntity.getDefaultObject());
		setEstudiante(EstudianteEntity.getDefaultObject());
	}

	public EventoEntity(UUID identificador, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
			TipoDuracionEventoEntity duracionEvento, EstadoEventoEntity estado, TipoEventoEntity tipoEvento,
			EstudianteEntity estudiante) {
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
	
	public static EventoEntity getDefaultObject() {
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

	public final TipoDuracionEventoEntity getDuracionEvento() {
		return duracionEvento;
	}

	private final void setDuracionEvento(final TipoDuracionEventoEntity duracionEvento) {
		this.duracionEvento = UtilObject.getDefault(duracionEvento, TipoDuracionEventoEntity.getDefaultObject());
	}

	public final EstadoEventoEntity getEstado() {
		return estado;
	}

	private final void setEstado(final EstadoEventoEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoEventoEntity.getDefaultObject());
	}

	public final TipoEventoEntity getTipoEvento() {
		return tipoEvento;
	}

	private final void setTipoEvento(final TipoEventoEntity tipoEvento) {
		this.tipoEvento = UtilObject.getDefault(tipoEvento, TipoEventoEntity.getDefaultObject());
	}

	public final EstudianteEntity getEstudiante() {
		return estudiante;
	}

	private final void setEstudiante(final EstudianteEntity estudiante) {
		this.estudiante = UtilObject.getDefault(estudiante, EstudianteEntity.getDefaultObject());
	}

}
