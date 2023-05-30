package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class NotificacionEntity {
	
	private static final NotificacionEntity DEFAULT_OBJECT = new NotificacionEntity();
	private UUID identificador;
	private EventoEntity evento;
	private int cantidadTiempo;
	private UnidadTiempoEntity unidadTiempo;
	private TipoNotificacionEntity tipoNotificacion;
	private EstadoNotificacionEntity estado;
	
	private NotificacionEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setEvento(EventoEntity.getDefaultObject());
		setCantidadTiempo(UtilNumber.ZERO.intValue());
		setUnidadTiempo(UnidadTiempoEntity.getDefaultObject());
		setTipoNotificacion(TipoNotificacionEntity.getDefaultObject());
		setEstado(EstadoNotificacionEntity.getDefaultObject());
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
	
	public static NotificacionEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final EventoEntity getEvento() {
		return evento;
	}

	private final void setEvento(final EventoEntity evento) {
		this.evento = UtilObject.getDefault(evento, EventoEntity.getDefaultObject());
	}

	public final int getCantidadTiempo() {
		return cantidadTiempo;
	}

	private final void setCantidadTiempo(final int cantidadTiempo) {
		this.cantidadTiempo = UtilNumber.getUtilNumber().getDefault(cantidadTiempo).intValue();
	}

	public final UnidadTiempoEntity getUnidadTiempo() {
		return unidadTiempo;
	}

	private final void setUnidadTiempo(final UnidadTiempoEntity unidadTiempo) {
		this.unidadTiempo = UtilObject.getDefault(unidadTiempo, UnidadTiempoEntity.getDefaultObject());
	}

	public final TipoNotificacionEntity getTipoNotificacion() {
		return tipoNotificacion;
	}

	private final void setTipoNotificacion(final TipoNotificacionEntity tipoNotificacion) {
		this.tipoNotificacion = UtilObject.getDefault(tipoNotificacion, TipoNotificacionEntity.getDefaultObject());
	}

	public final EstadoNotificacionEntity getEstado() {
		return estado;
	}

	private final void setEstado(final EstadoNotificacionEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoNotificacionEntity.getDefaultObject());
	}

}
