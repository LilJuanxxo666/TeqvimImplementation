package co.edu.uco.teqvim.business.domain;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class NotaDomain {

	private static final NotaDomain DEFAULT_OBJECT = new NotaDomain();
	private UUID identificador;
	private TipoNotaDomain tipoNota;
	private double calificacion;
	private String descripcion;
	private MateriaDomain materia;

	private NotaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoNota(TipoNotaDomain.getDefaultObject());
		setCalificacion(UtilNumber.ZERO.doubleValue());
		setDescripcion(UtilText.EMPTY);
		setMateria(MateriaDomain.getDefaultObject());
	}

	public NotaDomain(UUID identificador, TipoNotaDomain tipoNota, double calificacion, String descripcion) {
		super();
		setIdentificador(identificador);
		setTipoNota(tipoNota);
		setCalificacion(calificacion);
		setDescripcion(descripcion);
		setMateria(materia);
	}

	public static NotaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final TipoNotaDomain getTipoNota() {
		return tipoNota;
	}

	private final void setTipoNota(final TipoNotaDomain tipoNota) {
		this.tipoNota = UtilObject.getDefault(tipoNota, TipoNotaDomain.getDefaultObject());
	}

	public final double getCalificacion() {
		return calificacion;
	}

	private final void setCalificacion(final double calificacion) {
		this.calificacion = UtilNumber.getUtilNumber().getDefault(calificacion).doubleValue();
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
	}

	public final MateriaDomain getMateria() {
		return materia;
	}

	public final void setMateria(final MateriaDomain materia) {
		this.materia = UtilObject.getDefault(materia, MateriaDomain.getDefaultObject());
	}

}
