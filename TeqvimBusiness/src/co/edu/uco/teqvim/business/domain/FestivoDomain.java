package co.edu.uco.teqvim.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public class FestivoDomain {
	
	private static final FestivoDomain DEFAULT_OBJECT = new FestivoDomain();
	private UUID identificador;
	private TipoFestivoDomain tipo;
	private TipoFestivoFijoDomain tipoFijo;
	private LocalDate fecha;
	private String festividad;
	private PaisDomain paisCelebracion;

	private FestivoDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipo(TipoFestivoDomain.getDefaultObject());
		setTipoFijo(TipoFestivoFijoDomain.getDefaultObject());
		setFecha(UtilDate.DEFAULT_DATE);
		setFestividad(UtilText.EMPTY);
		setPaisCelebracion(PaisDomain.getDefaultObject());
	}

	public FestivoDomain(UUID identificador, TipoFestivoDomain tipo, TipoFestivoFijoDomain tipoFijo, LocalDate fecha,
			String festividad, PaisDomain paisCelebracion) {
		super();
		setIdentificador(identificador);
		setTipo(tipo);
		setTipoFijo(tipoFijo);
		setFecha(fecha);
		setFestividad(festividad);
		setPaisCelebracion(paisCelebracion);
	}

	public static FestivoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final TipoFestivoDomain getTipo() {
		return tipo;
	}

	private final void setTipo(final TipoFestivoDomain tipo) {
		this.tipo = UtilObject.getDefault(tipo, TipoFestivoDomain.getDefaultObject());
	}

	public final TipoFestivoFijoDomain getTipoFijo() {
		return tipoFijo;
	}

	private final void setTipoFijo(final TipoFestivoFijoDomain tipoFijo) {
		this.tipoFijo = UtilObject.getDefault(tipoFijo, TipoFestivoFijoDomain.getDefaultObject());
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

	public final PaisDomain getPaisCelebracion() {
		return paisCelebracion;
	}

	private final void setPaisCelebracion(final PaisDomain paisCelebracion) {
		this.paisCelebracion = UtilObject.getDefault(paisCelebracion, PaisDomain.getDefaultObject());
	}

}
