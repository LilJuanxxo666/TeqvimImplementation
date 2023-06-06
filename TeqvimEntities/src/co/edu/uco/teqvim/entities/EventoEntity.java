package co.edu.uco.teqvim.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class EventoEntity {
	
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
		setEstado(EstadoEventoEntity.create());
		setTipoEvento(TipoEventoEntity.create());
		setEstudiante(EstudianteEntity.create());
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
	
	public static EventoEntity create() {
		return new EventoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final EventoEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getTitulo() {
		return titulo;
	}

	public final EventoEntity setTitulo(final String titulo) {
		this.titulo = UtilText.getUtilText().applyTrim(titulo);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final EventoEntity setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public final EventoEntity setFechaInicio(final LocalDate fechaInicio) {
		this.fechaInicio = UtilDate.getDefault(fechaInicio);
		return this;
	}

	public final LocalDate getFechaFin() {
		return fechaFin;
	}

	public final EventoEntity setFechaFin(final LocalDate fechaFin) {
		this.fechaFin = UtilDate.getDefault(fechaFin);
		return this;
	}

	public final TipoDuracionEventoEntity getDuracionEvento() {
		return duracionEvento;
	}

	public final EventoEntity setDuracionEvento(final TipoDuracionEventoEntity duracionEvento) {
		this.duracionEvento = UtilObject.getDefault(duracionEvento, TipoDuracionEventoEntity.getDefaultObject());
		return this;
	}

	public final EstadoEventoEntity getEstado() {
		return estado;
	}

	public final EventoEntity setEstado(final EstadoEventoEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoEventoEntity.create());
		return this;
	}

	public final TipoEventoEntity getTipoEvento() {
		return tipoEvento;
	}

	public final EventoEntity setTipoEvento(final TipoEventoEntity tipoEvento) {
		this.tipoEvento = UtilObject.getDefault(tipoEvento, TipoEventoEntity.create());
		return this;
	}

	public final EstudianteEntity getEstudiante() {
		return estudiante;
	}

	public final EventoEntity setEstudiante(final EstudianteEntity estudiante) {
		this.estudiante = UtilObject.getDefault(estudiante, EstudianteEntity.create());
		return this;
	}

}
