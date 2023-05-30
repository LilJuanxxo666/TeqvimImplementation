package co.edu.uco.teqvim.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class EstudianteEntity {
	
	private static final EstudianteEntity DEFAULT_OBJECT = new EstudianteEntity();
	private UUID identificador;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segudoApellido;
	private String numeroTelefonico;
	private String correo;
	private String contrasena;
	private LocalDate fechaNacimiento;
	private TipoDocumentoEntity tipoDocumento;
	private String numeroDocumento;
	private RespuestaEntity confirmacionCorreo;
	private PaisEntity pais;
	private EstadoEstudianteEntity estado;
	
	private EstudianteEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setPrimerNombre(UtilText.EMPTY);
		setSegundoNombre(UtilText.EMPTY);
		setPrimerApellido(UtilText.EMPTY);
		setSegudoApellido(UtilText.EMPTY);
		setNumeroTelefonico(UtilText.EMPTY);
		setCorreo(UtilText.EMPTY);
		setContrasena(UtilText.EMPTY);
		setFechaNacimiento(UtilDate.DEFAULT_DATE);
		setTipoDocumento(TipoDocumentoEntity.getDefaultObject());
		setNumeroDocumento(UtilText.EMPTY);
		setConfirmacionCorreo(RespuestaEntity.getDefaultObject());
		setPais(PaisEntity.getDefaultObject());
		setEstado(EstadoEstudianteEntity.getDefaultObject());
	}

	public EstudianteEntity(UUID identificador, String primerNombre, String segundoNombre, String primerApellido,
			String segudoApellido, String numeroTelefonico, String correo, String contrasena, LocalDate fechaNacimiento,
			TipoDocumentoEntity tipoDocumento, String numeroDocumento, RespuestaEntity confirmacionCorreo, PaisEntity pais, EstadoEstudianteEntity estado) {
		super();
		setIdentificador(identificador);
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegudoApellido(segudoApellido);
		setNumeroTelefonico(numeroTelefonico);
		setCorreo(correo);
		setContrasena(contrasena);
		setFechaNacimiento(fechaNacimiento);
		setTipoDocumento(tipoDocumento);
		setNumeroDocumento(numeroDocumento);
		setConfirmacionCorreo(confirmacionCorreo);
		setPais(pais);
		setEstado(estado);
	}
	
	public static EstudianteEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}

	private final void setPrimerNombre(final String primerNombre) {
		this.primerNombre = UtilText.getUtilText().applyTrim(primerNombre);
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	private final void setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = UtilText.getUtilText().applyTrim(segundoNombre);
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	private final void setPrimerApellido(final String primerApellido) {
		this.primerApellido = UtilText.getUtilText().applyTrim(primerApellido);
	}

	public final String getSegudoApellido() {
		return segudoApellido;
	}

	private final void setSegudoApellido(final String segudoApellido) {
		this.segudoApellido = UtilText.getUtilText().applyTrim(segudoApellido);
	}

	public final String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	private final void setNumeroTelefonico(final String numeroTelefonico) {
		this.numeroTelefonico = UtilText.getUtilText().applyTrim(numeroTelefonico);
	}

	public final String getCorreo() {
		return correo;
	}

	private final void setCorreo(final String correo) {
		this.correo = UtilText.getDefaultEmail(correo);
	}

	public final String getContrasena() {
		return contrasena;
	}

	private final void setContrasena(final String contrasena) {
		this.contrasena = UtilText.getDefaultPassword(contrasena);
	}

	public final TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}

	private final void setTipoDocumento(final TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = UtilObject.getDefault(tipoDocumento, TipoDocumentoEntity.getDefaultObject());
	}

	public final String getNumeroDocumento() {
		return numeroDocumento;
	}

	private final void setNumeroDocumento(final String numeroDocumento) {
		this.numeroDocumento = UtilText.getUtilText().applyTrim(numeroDocumento);
	}

	public final RespuestaEntity getConfirmacionCorreo() {
		return confirmacionCorreo;
	}

	private final void setConfirmacionCorreo(final RespuestaEntity confirmacionCorreo) {
		this.confirmacionCorreo = UtilObject.getDefault(confirmacionCorreo, RespuestaEntity.getDefaultObject());
	}

	public final PaisEntity getPais() {
		return pais;
	}

	private final void setPais(final PaisEntity pais) {
		this.pais = UtilObject.getDefault(pais, PaisEntity.getDefaultObject());
	}

	public final EstadoEstudianteEntity getEstado() {
		return estado;
	}

	private final void setEstado(final EstadoEstudianteEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoEstudianteEntity.getDefaultObject());
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	private void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = UtilDate.getDefault(fechaNacimiento);
	}
	

}
