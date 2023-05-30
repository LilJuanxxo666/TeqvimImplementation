package co.edu.uco.teqvim.business.domain;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class NotificacionDomain {
	
	private static final NotificacionDomain DEFAULT_OBJECT = new NotificacionDomain();
	private UUID identificador;
	private EventoDomain evento;
	private int cantidadTiempo;
	private UnidadTiempoDomain unidadTiempo;
	private TipoNotificacionDomain tipoNotificacion;
	private EstadoNotificacionDomain estado;
	
	private NotificacionDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setEvento(EventoDomain.getDefaultObject());
		setCantidadTiempo(UtilNumber.ZERO.intValue());
		setUnidadTiempo(UnidadTiempoDomain.getDefaultObject());
		setTipoNotificacion(TipoNotificacionDomain.getDefaultObject());
		setEstado(EstadoNotificacionDomain.getDefaultObject());
	}

	public NotificacionDomain(UUID identificador, EventoDomain evento, int cantidadTiempo, UnidadTiempoDomain unidadTiempo,
			TipoNotificacionDomain tipoNotificacion, EstadoNotificacionDomain estado) {
		super();
		setIdentificador(identificador);
		setEvento(evento);
		setCantidadTiempo(cantidadTiempo);
		setUnidadTiempo(unidadTiempo);
		setTipoNotificacion(tipoNotificacion);
		setEstado(estado);
	}
	
	public static NotificacionDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final EventoDomain getEvento() {
		return evento;
	}

	private final void setEvento(final EventoDomain evento) {
		this.evento = UtilObject.getDefault(evento, EventoDomain.getDefaultObject());
	}

	public final int getCantidadTiempo() {
		return cantidadTiempo;
	}

	private final void setCantidadTiempo(final int cantidadTiempo) {
		this.cantidadTiempo = UtilNumber.getUtilNumber().getDefault(cantidadTiempo).intValue();
	}

	public final UnidadTiempoDomain getUnidadTiempo() {
		return unidadTiempo;
	}

	private final void setUnidadTiempo(final UnidadTiempoDomain unidadTiempo) {
		this.unidadTiempo = UtilObject.getDefault(unidadTiempo, UnidadTiempoDomain.getDefaultObject());
	}

	public final TipoNotificacionDomain getTipoNotificacion() {
		return tipoNotificacion;
	}

	private final void setTipoNotificacion(final TipoNotificacionDomain tipoNotificacion) {
		this.tipoNotificacion = UtilObject.getDefault(tipoNotificacion, TipoNotificacionDomain.getDefaultObject());
	}

	public final EstadoNotificacionDomain getEstado() {
		return estado;
	}

	private final void setEstado(final EstadoNotificacionDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoNotificacionDomain.getDefaultObject());
	}

}
