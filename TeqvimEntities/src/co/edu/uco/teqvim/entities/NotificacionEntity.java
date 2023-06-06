package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class NotificacionEntity {
	
	private UUID identificador;
	private EventoEntity evento;
	private int cantidadTiempo;
	private UnidadTiempoEntity unidadTiempo;
	private TipoNotificacionEntity tipoNotificacion;
	private EstadoNotificacionEntity estado;
	
	private NotificacionEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setEvento(EventoEntity.create());
		setCantidadTiempo(UtilNumber.ZERO.intValue());
		setUnidadTiempo(UnidadTiempoEntity.create());
		setTipoNotificacion(TipoNotificacionEntity.create());
		setEstado(EstadoNotificacionEntity.create());
	}

	public NotificacionEntity(UUID identificador, EventoEntity evento, int cantidadTiempo, UnidadTiempoEntity unidadTiempo,
			TipoNotificacionEntity tipoNotificacion, EstadoNotificacionEntity estado) {
		super();
		setIdentificador(identificador);
		setEvento(evento);
		setCantidadTiempo(cantidadTiempo);
		setUnidadTiempo(unidadTiempo);
		setTipoNotificacion(tipoNotificacion);
		setEstado(estado);
	}
	
	public static NotificacionEntity create() {
		return new NotificacionEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final NotificacionEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final EventoEntity getEvento() {
		return evento;
	}

	public final NotificacionEntity setEvento(final EventoEntity evento) {
		this.evento = UtilObject.getDefault(evento, EventoEntity.create());
		return this;
	}

	public final int getCantidadTiempo() {
		return cantidadTiempo;
	}

	public final NotificacionEntity setCantidadTiempo(final int cantidadTiempo) {
		this.cantidadTiempo = UtilNumber.getUtilNumber().getDefault(cantidadTiempo).intValue();
		return this;
	}

	public final UnidadTiempoEntity getUnidadTiempo() {
		return unidadTiempo;
	}

	public final NotificacionEntity setUnidadTiempo(final UnidadTiempoEntity unidadTiempo) {
		this.unidadTiempo = UtilObject.getDefault(unidadTiempo, UnidadTiempoEntity.create());
		return this;
	}

	public final TipoNotificacionEntity getTipoNotificacion() {
		return tipoNotificacion;
	}

	public final NotificacionEntity setTipoNotificacion(final TipoNotificacionEntity tipoNotificacion) {
		this.tipoNotificacion = UtilObject.getDefault(tipoNotificacion, TipoNotificacionEntity.create());
		return this;
	}

	public final EstadoNotificacionEntity getEstado() {
		return estado;
	}

	public final NotificacionEntity setEstado(final EstadoNotificacionEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoNotificacionEntity.create());
		return this;
	}

}
