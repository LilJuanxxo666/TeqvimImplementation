package co.edu.uco.teqvim.dto;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class FrecuenciaDTO {

	private UUID identificador;
	private int intervalo;
	private TipoFrecuenciaDTO tipoFrecuencia;
	
	public FrecuenciaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setIntervalo(UtilNumber.ZERO_INT);
		setTipoFrecuencia(TipoFrecuenciaDTO.create());
	}

	public FrecuenciaDTO(UUID identificador, int intervalo, TipoFrecuenciaDTO tipoFrecuencia) {
		super();
		setIdentificador(identificador);
		setIntervalo(intervalo);
		setTipoFrecuencia(tipoFrecuencia);
	}
	
	public static FrecuenciaDTO create() {
		return new FrecuenciaDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final FrecuenciaDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final int getIntervalo() {
		return intervalo;
	}

	public final FrecuenciaDTO setIntervalo(final int intervalo) {
		this.intervalo = intervalo;
		return this;
	}

	public final TipoFrecuenciaDTO getTipoFrecuencia() {
		return tipoFrecuencia;
	}

	public final FrecuenciaDTO setTipoFrecuencia(final TipoFrecuenciaDTO tipoFrecuencia) {
		this.tipoFrecuencia = UtilObject.getDefault(tipoFrecuencia, TipoFrecuenciaDTO.create());
		return this;
	}

}
