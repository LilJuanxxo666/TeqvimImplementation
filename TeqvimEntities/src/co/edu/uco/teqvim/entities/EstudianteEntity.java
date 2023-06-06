package co.edu.uco.teqvim.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class EstudianteEntity {
	
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
		setTipoDocumento(TipoDocumentoEntity.create());
		setNumeroDocumento(UtilText.EMPTY);
		setConfirmacionCorreo(RespuestaEntity.create());
		setPais(PaisEntity.create());
		setEstado(EstadoEstudianteEntity.create());
	}

	public EstudianteEntity(UUID identificador, String primerNombre, String segundoNombre, String primerApellido,
			String segudoApellido, String numeroTelefonico, String correo, String contrasena, LocalDate fechaNacimiento,
			TipoDocumentoEntity tipoDocumento, String numeroDocumento, RespuestaEntity confirmacionCorreo,
			PaisEntity pais, EstadoEstudianteEntity estado) {
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

	public static EstudianteEntity create() {
		return new EstudianteEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final EstudianteEntity setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}

	public final EstudianteEntity setPrimerNombre(final String primerNombre) {
		this.primerNombre = UtilText.getUtilText().applyTrim(primerNombre);
		return this;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	public final EstudianteEntity setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = UtilText.getUtilText().applyTrim(segundoNombre);
		return this;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	public final EstudianteEntity setPrimerApellido(final String primerApellido) {
		this.primerApellido = UtilText.getUtilText().applyTrim(primerApellido);
		return this;
	}

	public final String getSegudoApellido() {
		return segudoApellido;
	}

	public final EstudianteEntity setSegudoApellido(final String segudoApellido) {
		this.segudoApellido = UtilText.getUtilText().applyTrim(segudoApellido);
		return this;
	}

	public final String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public final EstudianteEntity setNumeroTelefonico(final String numeroTelefonico) {
		this.numeroTelefonico = UtilText.getUtilText().applyTrim(numeroTelefonico);
		return this;
	}

	public final String getCorreo() {
		return correo;
	}

	public final EstudianteEntity setCorreo(final String correo) {
		this.correo = UtilText.getDefaultEmail(correo);
		return this;
	}

	public final String getContrasena() {
		return contrasena;
	}

	public final EstudianteEntity setContrasena(final String contrasena) {
		this.contrasena = UtilText.getDefaultPassword(contrasena);
		return this;
	}

	public final TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}

	public final EstudianteEntity setTipoDocumento(final TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = UtilObject.getDefault(tipoDocumento, TipoDocumentoEntity.create());
		return this;
	}

	public final String getNumeroDocumento() {
		return numeroDocumento;
	}

	public final EstudianteEntity setNumeroDocumento(final String numeroDocumento) {
		this.numeroDocumento = UtilText.getUtilText().applyTrim(numeroDocumento);
		return this;
	}

	public final RespuestaEntity getConfirmacionCorreo() {
		return confirmacionCorreo;
	}

	public final EstudianteEntity setConfirmacionCorreo(final RespuestaEntity confirmacionCorreo) {
		this.confirmacionCorreo = UtilObject.getDefault(confirmacionCorreo, RespuestaEntity.create());
		return this;
	}

	public final PaisEntity getPais() {
		return pais;
	}

	public final EstudianteEntity setPais(final PaisEntity pais) {
		this.pais = UtilObject.getDefault(pais, PaisEntity.create());
		return this;
	}

	public final EstadoEstudianteEntity getEstado() {
		return estado;
	}

	public final EstudianteEntity setEstado(final EstadoEstudianteEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoEstudianteEntity.create());
		return this;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public EstudianteEntity setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = UtilDate.getDefault(fechaNacimiento);
		return this;
	}

}
