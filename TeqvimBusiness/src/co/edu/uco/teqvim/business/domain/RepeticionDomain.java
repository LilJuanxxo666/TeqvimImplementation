package co.edu.uco.teqvim.business.domain;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilList;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;


public final class RepeticionDomain {

	private static final RepeticionDomain DEFAULT_OBJECT = new RepeticionDomain();
	private UUID identificador;
	private EventoDomain evento;
	private DuracionDomain duracion;
	private FrecuenciaDomain frecuencia;
	private List<DayOfWeek> diaSemana;

	private RepeticionDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setEvento(EventoDomain.getDefaultObject());
		setDuracion(DuracionDomain.getDefaultObject());
		setFrecuencia(FrecuenciaDomain.getDefaultObject());
		setDiaSemana(UtilList.getDefaultList());
	}

	public RepeticionDomain(final UUID identificador, final EventoDomain evento, final DuracionDomain duracion,
			final FrecuenciaDomain frecuencia, List<DayOfWeek> diaSemana) {
		super();
		setIdentificador(identificador);
		setEvento(evento);
		setDuracion(duracion);
		setFrecuencia(frecuencia);
		setDiaSemana(diaSemana);
	}
	
	public static RepeticionDomain getDefaultObject() {
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

	public final DuracionDomain getDuracion() {
		return duracion;
	}

	private final void setDuracion(final DuracionDomain duracion) {
		this.duracion = UtilObject.getDefault(duracion, DuracionDomain.getDefaultObject());
	}

	public final FrecuenciaDomain getFrecuencia() {
		return frecuencia;
	}

	private final void setFrecuencia(final FrecuenciaDomain frecuencia) {
		this.frecuencia = UtilObject.getDefault(frecuencia, FrecuenciaDomain.getDefaultObject());
	}

	public final List<DayOfWeek> getDiaSemana() {
		return diaSemana;
	}

	private final void setDiaSemana(List<DayOfWeek> diaSemana) {
		this.diaSemana = UtilList.getDefault(diaSemana);
	}

}
