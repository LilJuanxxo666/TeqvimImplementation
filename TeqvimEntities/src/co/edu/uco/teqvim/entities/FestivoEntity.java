package co.edu.uco.teqvim.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class FestivoEntity {
	
	private static final FestivoEntity DEFAULT_OBJECT = new FestivoEntity();
	private UUID identificador;
	private TipoFestivoEntity tipo;
	private TipoFestivoFijoEntity tipoFijo;
	private LocalDate fecha;
	private String festividad;
	private PaisEntity paisCelebracion;

	private FestivoEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipo(TipoFestivoEntity.getDefaultObject());
		setTipoFijo(TipoFestivoFijoEntity.getDefaultObject());
		setFecha(UtilDate.DEFAULT_DATE);
		setFestividad(UtilText.EMPTY);
		setPaisCelebracion(PaisEntity.getDefaultObject());
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

	public static FestivoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final TipoFestivoEntity getTipo() {
		return tipo;
	}

	private final void setTipo(final TipoFestivoEntity tipo) {
		this.tipo = UtilObject.getDefault(tipo, TipoFestivoEntity.getDefaultObject());
	}

	public final TipoFestivoFijoEntity getTipoFijo() {
		return tipoFijo;
	}

	private final void setTipoFijo(final TipoFestivoFijoEntity tipoFijo) {
		this.tipoFijo = UtilObject.getDefault(tipoFijo, TipoFestivoFijoEntity.getDefaultObject());
	}

	public final LocalDate getFecha() {
		return fecha;
	}

	private final void setFecha(final LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
	}

	public final String getFestividad() {
		return festividad;
	}

	private final void setFestividad(final String festividad) {
		this.festividad = UtilText.getUtilText().applyTrim(festividad);
	}

	public final PaisEntity getPaisCelebracion() {
		return paisCelebracion;
	}

	private final void setPaisCelebracion(final PaisEntity paisCelebracion) {
		this.paisCelebracion = UtilObject.getDefault(paisCelebracion, PaisEntity.getDefaultObject());
	}

}
