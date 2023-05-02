package co.edu.uco.teqvim.dto;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilList;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class RepeticionDTO {

	private UUID identificador;
	private EventoDTO evento;
	private DuracionDTO duracion;
	private FrecuenciaDTO frecuencia;
	private List<DayOfWeek> diaSemana;
	
	public RepeticionDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setEvento(EventoDTO.create());
		setDuracion(DuracionDTO.create());
		setFrecuencia(FrecuenciaDTO.create());
		setDiaSemana(UtilList.getDefaultList());
	}

	public RepeticionDTO(final UUID identificador, final EventoDTO evento, final DuracionDTO duracion, final FrecuenciaDTO frecuencia,
			List<DayOfWeek> diaSemana) {
		super();
		setIdentificador(identificador);
		setEvento(evento);
		setDuracion(duracion);
		setFrecuencia(frecuencia);
		setDiaSemana(diaSemana);
	}
	
	public static RepeticionDTO create() {
		return new RepeticionDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final RepeticionDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final EventoDTO getEvento() {
		return evento;
	}

	public final RepeticionDTO setEvento(final EventoDTO evento) {
		this.evento = UtilObject.getDefault(evento, EventoDTO.create());
		return this;
	}

	public final DuracionDTO getDuracion() {
		return duracion;
	}

	public final RepeticionDTO setDuracion(final DuracionDTO duracion) {
		this.duracion = UtilObject.getDefault(duracion, DuracionDTO.create());
		return this;
	}

	public final FrecuenciaDTO getFrecuencia() {
		return frecuencia;
	}

	public final RepeticionDTO setFrecuencia(final FrecuenciaDTO frecuencia) {
		this.frecuencia = UtilObject.getDefault(frecuencia, FrecuenciaDTO.create());
		return this;
	}

	public final List<DayOfWeek> getDiaSemana() {
		return diaSemana;
	}

	public final RepeticionDTO setDiaSemana(List<DayOfWeek> diaSemana) {
		this.diaSemana = UtilList.getDefault(diaSemana);
		return this;
	}

}
