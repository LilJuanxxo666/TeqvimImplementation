package co.edu.uco.teqvim.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class FestivoEntity {
	
	private UUID identificador;
	private TipoFestivoEntity tipo;
	private TipoFestivoFijoEntity tipoFijo;
	private LocalDate fecha;
	private String festividad;
	private PaisEntity paisCelebracion;

	private FestivoEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipo(TipoFestivoEntity.create());
		setTipoFijo(TipoFestivoFijoEntity.getDefaultObject());
		setFecha(UtilDate.DEFAULT_DATE);
		setFestividad(UtilText.EMPTY);
		setPaisCelebracion(PaisEntity.create());
	}

	public FestivoEntity(UUID identificador, TipoFestivoEntity tipo, TipoFestivoFijoEntity tipoFijo, LocalDate fecha,
			String festividad, PaisEntity paisCelebracion) {
		super();
		setIdentificador(identificador);
		setTipo(tipo);
		setTipoFijo(tipoFijo);
		setFecha(fecha);
		setFestividad(festividad);
		setPaisCelebracion(paisCelebracion);
	}

	public static FestivoEntity create() {
		return new FestivoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final FestivoEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final TipoFestivoEntity getTipo() {
		return tipo;
	}

	public final FestivoEntity setTipo(final TipoFestivoEntity tipo) {
		this.tipo = UtilObject.getDefault(tipo, TipoFestivoEntity.create());
		return this;
	}

	public final TipoFestivoFijoEntity getTipoFijo() {
		return tipoFijo;
	}

	public final FestivoEntity setTipoFijo(final TipoFestivoFijoEntity tipoFijo) {
		this.tipoFijo = UtilObject.getDefault(tipoFijo, TipoFestivoFijoEntity.getDefaultObject());
		return this;
	}

	public final LocalDate getFecha() {
		return fecha;
	}

	public final FestivoEntity setFecha(final LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
		return this;
	}

	public final String getFestividad() {
		return festividad;
	}

	public final FestivoEntity setFestividad(final String festividad) {
		this.festividad = UtilText.getUtilText().applyTrim(festividad);
		return this;
	}

	public final PaisEntity getPaisCelebracion() {
		return paisCelebracion;
	}

	public final FestivoEntity setPaisCelebracion(final PaisEntity paisCelebracion) {
		this.paisCelebracion = UtilObject.getDefault(paisCelebracion, PaisEntity.create());
		return this;
	}

}
