package co.edu.uco.teqvim.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class EventoDTO {

	private UUID identificador;
	private String titulo;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private TipoDuracionEventoDTO duracionEvento;
	private EstadoEventoDTO estado;
	private TipoEventoDTO tipoEvento;
	private EstudianteDTO estudiante;
	
	public EventoDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTitulo(UtilText.EMPTY);
		setDescripcion(UtilText.EMPTY);
		setFechaInicio(UtilDate.DEFAULT_DATE);
		setFechaFin(UtilDate.DEFAULT_DATE);
		setDuracionEvento(TipoDuracionEventoDTO.create());
		setEstado(EstadoEventoDTO.create());
		setTipoEvento(TipoEventoDTO.create());
		setEstudiante(EstudianteDTO.create());
	}

	public EventoDTO(UUID identificador, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
			TipoDuracionEventoDTO duracionEvento, EstadoEventoDTO estado, TipoEventoDTO tipoEvento,
			EstudianteDTO estudiante) {
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
	
	public static EventoDTO create() {
		return new EventoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final EventoDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getTitulo() {
		return titulo;
	}

	public final EventoDTO setTitulo(final String titulo) {
		this.titulo = UtilText.getUtilText().applyTrim(titulo);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final EventoDTO setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public final EventoDTO setFechaInicio(final LocalDate fechaInicio) {
		this.fechaInicio = UtilDate.getDefault(fechaInicio);
		return this;
	}

	public final LocalDate getFechaFin() {
		return fechaFin;
	}

	public final EventoDTO setFechaFin(final LocalDate fechaFin) {
		this.fechaFin = UtilDate.getDefault(fechaFin);
		return this;
	}

	public final TipoDuracionEventoDTO getDuracionEvento() {
		return duracionEvento;
	}

	public final EventoDTO setDuracionEvento(final TipoDuracionEventoDTO duracionEvento) {
		this.duracionEvento = UtilObject.getDefault(duracionEvento, TipoDuracionEventoDTO.create());
		return this;
	}

	public final EstadoEventoDTO getEstado() {
		return estado;
	}

	public final EventoDTO setEstado(final EstadoEventoDTO estado) {
		this.estado = UtilObject.getDefault(estado, EstadoEventoDTO.create());
		return this;
	}

	public final TipoEventoDTO getTipoEvento() {
		return tipoEvento;
	}

	public final EventoDTO setTipoEvento(final TipoEventoDTO tipoEvento) {
		this.tipoEvento = UtilObject.getDefault(tipoEvento, TipoEventoDTO.create());
		return this;
	}

	public final EstudianteDTO getEstudiante() {
		return estudiante;
	}

	public final EventoDTO setEstudiante(final EstudianteDTO estudiante) {
		this.estudiante = UtilObject.getDefault(estudiante, EstudianteDTO.create());
		return this;
	}

}
