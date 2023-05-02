package co.edu.uco.teqvim.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class FestivoDTO {

	private UUID identificador;
	private TipoFestivoDTO tipo;
	private TipoFestivoFijoDTO tipoFijo;
	private LocalDate fecha;
	private String festividad;
	private PaisDTO paisCelebracion;

	public FestivoDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipo(TipoFestivoDTO.create());
		setTipoFijo(TipoFestivoFijoDTO.create());
		setFecha(UtilDate.DEFAULT_DATE);
		setFestividad(UtilText.EMPTY);
		setPaisCelebracion(PaisDTO.create());
	}

	public FestivoDTO(UUID identificador, TipoFestivoDTO tipo, TipoFestivoFijoDTO tipoFijo, LocalDate fecha,
			String festividad, PaisDTO paisCelebracion) {
		super();
		setIdentificador(identificador);
		setTipo(tipo);
		setTipoFijo(tipoFijo);
		setFecha(fecha);
		setFestividad(festividad);
		setPaisCelebracion(paisCelebracion);
	}

	public static FestivoDTO create() {
		return new FestivoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final FestivoDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final TipoFestivoDTO getTipo() {
		return tipo;
	}

	public final FestivoDTO setTipo(final TipoFestivoDTO tipo) {
		this.tipo = UtilObject.getDefault(tipo, TipoFestivoDTO.create());
		return this;
	}

	public final TipoFestivoFijoDTO getTipoFijo() {
		return tipoFijo;
	}

	public final FestivoDTO setTipoFijo(final TipoFestivoFijoDTO tipoFijo) {
		this.tipoFijo = UtilObject.getDefault(tipoFijo, TipoFestivoFijoDTO.create());
		return this;
	}

	public final LocalDate getFecha() {
		return fecha;
	}

	public final FestivoDTO setFecha(final LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
		return this;
	}

	public final String getFestividad() {
		return festividad;
	}

	public final FestivoDTO setFestividad(final String festividad) {
		this.festividad = UtilText.getUtilText().applyTrim(festividad);
		return this;
	}

	public final PaisDTO getPaisCelebracion() {
		return paisCelebracion;
	}

	public final FestivoDTO setPaisCelebracion(final PaisDTO paisCelebracion) {
		this.paisCelebracion = UtilObject.getDefault(paisCelebracion, PaisDTO.create());
		return this;
	}

}
