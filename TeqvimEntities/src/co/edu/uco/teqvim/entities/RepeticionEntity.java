package co.edu.uco.teqvim.entities;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilList;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;


public final class RepeticionEntity {

	private static final RepeticionEntity DEFAULT_OBJECT = new RepeticionEntity();
	private UUID identificador;
	private EventoEntity evento;
	private DuracionEntity duracion;
	private FrecuenciaEntity frecuencia;
	private List<DayOfWeek> diaSemana;

	private RepeticionEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setEvento(EventoEntity.getDefaultObject());
		setDuracion(DuracionEntity.getDefaultObject());
		setFrecuencia(FrecuenciaEntity.getDefaultObject());
		setDiaSemana(UtilList.getDefaultList());
	}

	public RepeticionEntity(final UUID identificador, final EventoEntity evento, final DuracionEntity duracion,
			final FrecuenciaEntity frecuencia, List<DayOfWeek> diaSemana) {
		super();
		setIdentificador(identificador);
		setEvento(evento);
		setDuracion(duracion);
		setFrecuencia(frecuencia);
		setDiaSemana(diaSemana);
	}
	
	public static RepeticionEntity getDefaultObject() {
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

	public final DuracionEntity getDuracion() {
		return duracion;
	}

	private final void setDuracion(final DuracionEntity duracion) {
		this.duracion = UtilObject.getDefault(duracion, DuracionEntity.getDefaultObject());
	}

	public final FrecuenciaEntity getFrecuencia() {
		return frecuencia;
	}

	private final void setFrecuencia(final FrecuenciaEntity frecuencia) {
		this.frecuencia = UtilObject.getDefault(frecuencia, FrecuenciaEntity.getDefaultObject());
	}

	public final List<DayOfWeek> getDiaSemana() {
		return diaSemana;
	}

	private final void setDiaSemana(List<DayOfWeek> diaSemana) {
		this.diaSemana = UtilList.getDefault(diaSemana);
	}

}
