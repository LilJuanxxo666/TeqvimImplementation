package co.edu.uco.teqvim.entities;

import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class NotaEntity {

	private static final NotaEntity DEFAULT_OBJECT = new NotaEntity();
	private UUID identificador;
	private TipoNotaEntity tipoNota;
	private double calificacion;
	private String descripcion;
	private MateriaEntity materia;

	private NotaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoNota(TipoNotaEntity.getDefaultObject());
		setCalificacion(UtilNumber.ZERO.doubleValue());
		setDescripcion(UtilText.EMPTY);
		setMateria(MateriaEntity.getDefaultObject());
	}

	public NotaEntity(UUID identificador, TipoNotaEntity tipoNota, double calificacion, String descripcion) {
		super();
		setIdentificador(identificador);
		setTipoNota(tipoNota);
		setCalificacion(calificacion);
		setDescripcion(descripcion);
		setMateria(materia);
	}

	public static NotaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final TipoNotaEntity getTipoNota() {
		return tipoNota;
	}

	private final void setTipoNota(final TipoNotaEntity tipoNota) {
		this.tipoNota = UtilObject.getDefault(tipoNota, TipoNotaEntity.getDefaultObject());
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

	public final MateriaEntity getMateria() {
		return materia;
	}

	private final NotaEntity setMateria(final MateriaEntity materia) {
		this.materia = UtilObject.getDefault(materia, MateriaEntity.getDefaultObject());
		return this;
	}

}
