package co.edu.uco.teqvim.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;

public final class EstudianteDTO {

	private UUID identificador;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segudoApellido;
	private String numeroTelefonico;
	private String correo;
	private String contrasena;
	private LocalDate fechaNacimiento;
	private TipoDocumentoDTO tipoDocumento;
	private String numeroDocumento;
	private RespuestaDTO confirmacionCorreo;
	private PaisDTO pais;
	private EstadoEstudianteDTO estado;

	public EstudianteDTO() {
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
		setTipoDocumento(TipoDocumentoDTO.create());
		setNumeroDocumento(UtilText.EMPTY);
		setConfirmacionCorreo(RespuestaDTO.create());
		setPais(PaisDTO.create());
		setEstado(EstadoEstudianteDTO.create());
	}

	public EstudianteDTO(UUID identificador, String primerNombre, String segundoNombre, String primerApellido,
			String segudoApellido, String numeroTelefonico, String correo, String contrasena, LocalDate fechaNacimiento,
			TipoDocumentoDTO tipoDocumento, String numeroDocumento, RespuestaDTO confirmacionCorreo,
			PaisDTO pais, EstadoEstudianteDTO estado) {
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

	public static EstudianteDTO create() {
		return new EstudianteDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final EstudianteDTO setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}

	public final EstudianteDTO setPrimerNombre(final String primerNombre) {
		this.primerNombre = UtilText.getUtilText().applyTrim(primerNombre);
		return this;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	public final EstudianteDTO setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = UtilText.getUtilText().applyTrim(segundoNombre);
		return this;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	public final EstudianteDTO setPrimerApellido(final String primerApellido) {
		this.primerApellido = UtilText.getUtilText().applyTrim(primerApellido);
		return this;
	}

	public final String getSegudoApellido() {
		return segudoApellido;
	}

	public final EstudianteDTO setSegudoApellido(final String segudoApellido) {
		this.segudoApellido = UtilText.getUtilText().applyTrim(segudoApellido);
		return this;
	}

	public final String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public final EstudianteDTO setNumeroTelefonico(final String numeroTelefonico) {
		this.numeroTelefonico = UtilText.getUtilText().applyTrim(numeroTelefonico);
		return this;
	}

	public final String getCorreo() {
		return correo;
	}

	public final EstudianteDTO setCorreo(final String correo) {
		this.correo = UtilText.getDefaultEmail(correo);
		return this;
	}

	public final LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final EstudianteDTO setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = UtilDate.getDefault(fechaNacimiento);
		return this;
	}
	
	public final String getContrasena() {
		return contrasena;
	}

	public final EstudianteDTO setContrasena(final String contrasena) {
		this.contrasena = UtilText.getDefaultPassword(contrasena);
		return this;
	}

	public final TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public final EstudianteDTO setTipoDocumento(final TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = UtilObject.getDefault(tipoDocumento, TipoDocumentoDTO.create());
		return this;
	}

	public final String getNumeroDocumento() {
		return numeroDocumento;
	}

	public final EstudianteDTO setNumeroDocumento(final String numeroDocumento) {
		this.numeroDocumento = UtilText.getUtilText().applyTrim(numeroDocumento);
		return this;
	}

	public final RespuestaDTO getConfirmacionCorreo() {
		return confirmacionCorreo;
	}

	public final EstudianteDTO setConfirmacionCorreo(final RespuestaDTO confirmacionCorreo) {
		this.confirmacionCorreo = UtilObject.getDefault(confirmacionCorreo, RespuestaDTO.create());
		return this;
	}

	public final PaisDTO getPais() {
		return pais;
	}

	public final EstudianteDTO setPais(final PaisDTO pais) {
		this.pais = UtilObject.getDefault(pais, PaisDTO.create());
		return this;
	}

	public final EstadoEstudianteDTO getEstado() {
		return estado;
	}

	public final EstudianteDTO setEstado(final EstadoEstudianteDTO estado) {
		this.estado = UtilObject.getDefault(estado, EstadoEstudianteDTO.create());
		return this;
	}
}
