package co.edu.uco.teqvim.dto;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class NotificacionDTO {

	private UUID identificador;
	private EventoDTO evento;
	private int cantidadTiempo;
	private UnidadTiempoDTO unidadTiempo;
	private TipoNotificacionDTO tipoNotificacion;
	private EstadoNotificacionDTO estado;
	
	public NotificacionDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setEvento(EventoDTO.create());
		setCantidadTiempo(UtilNumber.ZERO.intValue());
		setUnidadTiempo(UnidadTiempoDTO.create());
		setTipoNotificacion(TipoNotificacionDTO.create());
		setEstado(EstadoNotificacionDTO.create());
	}

	public NotificacionDTO(UUID identificador, EventoDTO evento, int cantidadTiempo, UnidadTiempoDTO unidadTiempo,
			TipoNotificacionDTO tipoNotificacion, EstadoNotificacionDTO estado) {
		super();
		setIdentificador(identificador);
		setEvento(evento);
		setCantidadTiempo(cantidadTiempo);
		setUnidadTiempo(unidadTiempo);
		setTipoNotificacion(tipoNotificacion);
		setEstado(estado);
	}
	
	public static NotificacionDTO create() {
		return new NotificacionDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final NotificacionDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final EventoDTO getEvento() {
		return evento;
	}

	public final NotificacionDTO setEvento(final EventoDTO evento) {
		this.evento = UtilObject.getDefault(evento, EventoDTO.create());
		return this;
	}

	public final int getCantidadTiempo() {
		return cantidadTiempo;
	}

	public final NotificacionDTO setCantidadTiempo(final int cantidadTiempo) {
		this.cantidadTiempo = UtilNumber.getUtilNumber().getDefault(cantidadTiempo).intValue();
		return this;
	}

	public final UnidadTiempoDTO getUnidadTiempo() {
		return unidadTiempo;
	}

	public final NotificacionDTO setUnidadTiempo(final UnidadTiempoDTO unidadTiempo) {
		this.unidadTiempo = UtilObject.getDefault(unidadTiempo, UnidadTiempoDTO.create());
		return this;
	}

	public final TipoNotificacionDTO getTipoNotificacion() {
		return tipoNotificacion;
	}

	public final NotificacionDTO setTipoNotificacion(final TipoNotificacionDTO tipoNotificacion) {
		this.tipoNotificacion = UtilObject.getDefault(tipoNotificacion, TipoNotificacionDTO.create());
		return this;
	}

	public final EstadoNotificacionDTO getEstado() {
		return estado;
	}

	public final NotificacionDTO setEstado(final EstadoNotificacionDTO estado) {
		this.estado = UtilObject.getDefault(estado, EstadoNotificacionDTO.create());
		return this; 
	}

}
