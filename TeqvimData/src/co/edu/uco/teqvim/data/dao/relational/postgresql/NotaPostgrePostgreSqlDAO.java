package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.exception.TeqvimDataException;
import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;
import co.edu.uco.teqvim.crosscutting.utils.Messages.NotaPostgresSqlDAOMessages;
import co.edu.uco.teqvim.data.dao.NotaDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;
import co.edu.uco.teqvim.entities.EstadoPeriodoAcademicoEntity;
import co.edu.uco.teqvim.entities.EstudianteEntity;
import co.edu.uco.teqvim.entities.MateriaEntity;
import co.edu.uco.teqvim.entities.NotaEntity;
import co.edu.uco.teqvim.entities.PaisEntity;
import co.edu.uco.teqvim.entities.PeriodoAcademicoEntity;
import co.edu.uco.teqvim.entities.RespuestaEntity;
import co.edu.uco.teqvim.entities.TipoDocumentoEntity;
import co.edu.uco.teqvim.entities.TipoNotaEntity;
import co.edu.uco.teqvim.entities.TipoPeriodoAcademicoEntity;

public final class NotaPostgrePostgreSqlDAO extends SqlDAO<NotaEntity> implements NotaDAO {

	public NotaPostgrePostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(NotaEntity entity) {
		var sqlStatement = "INSERT INTO nota (identificador, tipo_nota, calificacion, descripcion, materia, porcentaje) VALUES (?,?,?,?,?,?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setObject(2, entity.getTipoNota().getIdentificador());
			preparedStatement.setDouble(3, entity.getCalificacion());
			preparedStatement.setString(4, entity.getDescripcion());
			preparedStatement.setObject(5, entity.getMateria().getIdentificador());
			preparedStatement.setDouble(6, entity.getPorcentaje());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {

			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.CREATE_TECHNICAL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);
		}

	}

	@Override
	public List<NotaEntity> read(NotaEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();

		sqlStatement.append(prepareSelect());
		sqlStatement.append(prepareFrom());
		sqlStatement.append(prepareWhere(entity, parameters));
		sqlStatement.append(prepareOrderBy());

		try (var preaparedStatement = getConnection().prepareStatement(sqlStatement.toString())) {

			setParameters(preaparedStatement, parameters);

			return executeQuery(preaparedStatement);

		} catch (final TeqvimDataException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.READ_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.READ_TECHNICAL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public void update(NotaEntity entity) {
		var sqlStatement = "UPDATE nota SET tipo_nota=?, calificacion=?, descripcion=?, materia=?, porcentaje=? WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			
			preparedStatement.setObject(1, entity.getTipoNota().getIdentificador());
			preparedStatement.setDouble(2, entity.getCalificacion());
			preparedStatement.setString(3, entity.getDescripcion());
			preparedStatement.setObject(4, entity.getMateria().getIdentificador());
			preparedStatement.setDouble(5, entity.getPorcentaje());
			preparedStatement.setObject(6, entity.getIdentificador());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public void delete(NotaEntity entity) {
		var sqlStatement = "DELETE FROM nota WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected String prepareSelect() {
		return "SELECT NTA.identificador, NTA.tipo_nota, TNO.nombre, TNO.descripcion, NTA.calificacion, NTA.descripcion, NTA.materia, MAT.nombre, MAT.creditos, MAT.periodo_academico, PEA.nombre, PEA.fecha_inicio, PEA.fecha_fin, PEA.tipo_periodo_academico, TPA.nombre, TPA.descripcion, PEA.estado_periodo_academico, EPA.nombre, EPA.descripcion, PEA.estudiante, EST.primer_nombre, EST.segundo_nombre, EST.primer_apellido, EST.segundo_apellido, EST.numero_telefonico, EST.correo, EST.fecha_nacimiento, EST.tipo_documento, TDO.nombre, TDO.descripcion, EST.numero_documento, EST.confirmacion_correo, CCO.nombre, CCO.descripcion, EST.pais, PAI.nombre, EST.estado_estudiante, ES.nombre, ES.descripcion, PEA.promedio_periodo, MAT.promedio_materia, NTA.porcentaje ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM nota NTA JOIN tipo_nota TNO ON TNO.identificador = NTA.tipo_nota JOIN materia MAT ON MAT.identificador = NTA.materia JOIN periodo_academico PEA ON PEA.identificador = MAT.periodo_academico JOIN tipo_periodo_academico TPA ON TPA.identificador = PEA.tipo_periodo_academico JOIN estado_periodo_academico EPA ON EPA.identificador = PEA.estado_periodo_academico JOIN estudiante EST ON EST.identificador = PEA.estudiante JOIN tipo_documento TDO ON TDO.identificador = EST.tipo_documento JOIN respuesta CCO ON EST.confirmacion_correo = CCO.identificador JOIN pais PAI ON PAI.identificador = EST.pais JOIN estado_estudiante ES ON ES.identificador = EST.estado_estudiante ";
	}

	@Override
	protected String prepareWhere(NotaEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		var setWhere = true;

		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE NTA.identificador=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getTipoNota().getIdentificador())) {
				parameters.add(entity.getTipoNota().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("NTA.tipo_nota=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getTipoNota().getNombre())) {
				parameters.add(entity.getTipoNota().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("TNO.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getTipoNota().getDescripcion())) {
				parameters.add(entity.getTipoNota().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("TNO.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilNumber.getUtilNumber().isZero(entity.getCalificacion())) {
				parameters.add(entity.getCalificacion());
				where.append(setWhere ? "WHERE " : "AND ").append("NTA.calificacion=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("NTA.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getMateria().getIdentificador())) {
				parameters.add(entity.getMateria().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("NTA.materia=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getNombre())) {
				parameters.add(entity.getMateria().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("MAT.nombre=? ");
				setWhere = false;
			}
			if (!UtilNumber.getUtilNumber().isZero(entity.getMateria().getCreditos())) {
				parameters.add(entity.getMateria().getCreditos());
				where.append(setWhere ? "WHERE " : "AND ").append("MAT.creditos=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getMateria().getPeriodoAcademico().getIdentificador())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("MAT.periodo_academico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getNombre())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.nombre=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getMateria().getPeriodoAcademico().getFechaInicio())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getFechaInicio());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.fecha_inicio=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getMateria().getPeriodoAcademico().getFechaFin())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getFechaFin());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.fecha_fin=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getMateria().getPeriodoAcademico().getTipoPeriodo().getIdentificador())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getTipoPeriodo().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.tipo_periodo_academico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getTipoPeriodo().getNombre())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getTipoPeriodo().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("TPA.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getTipoPeriodo().getDescripcion())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getTipoPeriodo().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("TPA.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getMateria().getPeriodoAcademico().getEstado().getIdentificador())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.estado_periodo_academico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstado().getNombre())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstado().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("EPA.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstado().getDescripcion())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstado().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("EPA.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getPrimerNombre())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getPrimerNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.primer_nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getSegundoNombre())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getSegundoNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.segundo_nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getPrimerApellido())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getPrimerApellido());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.primer_apellido=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getSegudoApellido())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getPrimerApellido());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.segundo_apellido=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getNumeroTelefonico())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getNumeroTelefonico());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.numero_telefonico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getCorreo())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getCorreo());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.correo=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getMateria().getPeriodoAcademico().getEstudiante().getFechaNacimiento())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getFechaNacimiento());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.fecha_nacimiento=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getMateria().getPeriodoAcademico().getEstudiante().getTipoDocumento().getIdentificador())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getTipoDocumento().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.tipo_documento=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getTipoDocumento().getNombre())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getTipoDocumento().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("TDO.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getTipoDocumento().getDescripcion())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getTipoDocumento().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("TDO.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getNumeroDocumento())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getNumeroDocumento());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.numero_documento=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getMateria().getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getIdentificador())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.confirmacion_correo=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getNombre())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("CCO.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getDescripcion())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("CCO.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getMateria().getPeriodoAcademico().getEstudiante().getPais().getIdentificador())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getPais().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.pais=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getPais().getNombre())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getPais().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("PAI.nombre=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getMateria().getPeriodoAcademico().getEstudiante().getEstado().getIdentificador())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.estado_estudiante=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getEstado().getNombre())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstado().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("ES.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getMateria().getPeriodoAcademico().getEstudiante().getEstado().getDescripcion())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getEstudiante().getEstado().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("ES.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilNumber.getUtilNumber().isZero(entity.getMateria().getPeriodoAcademico().getPromedioPeriodo())) {
				parameters.add(entity.getMateria().getPeriodoAcademico().getPromedioPeriodo());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.promedio_periodo=? ");
				setWhere = false;
			}
			if (!UtilNumber.getUtilNumber().isZero(entity.getMateria().getPromedioMateria())) {
				parameters.add(entity.getMateria().getPromedioMateria());
				where.append(setWhere ? "WHERE " : "AND ").append("MAT.promedio_materia=? ");
			}
		}
		return where.toString();
	}

	@Override
	protected String prepareOrderBy() {
		return "ORDER BY TNO.nombre ASC";
	}

	@Override
	protected void setParameters(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			if (!UtilObject.isNull(parameters) && !UtilObject.isNull(preparedStatement)) {
				for (int i = 0; i < parameters.size(); i++) {
					preparedStatement.setObject(i + 1, parameters.get(i));
				}
			}
		} catch (final SQLException exception) {
			throw TeqvimDataException.create(
					NotaPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(
					NotaPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE,
					NotaPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected List<NotaEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<NotaEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				NotaEntity entityTmp = NotaEntity.create().setIdentificador(resultSet.getObject(1, UUID.class)).
						setTipoNota(TipoNotaEntity.create().setIdentificador(resultSet.getObject(2, UUID.class)).
								setNombre(resultSet.getString(3)).setDescripcion(resultSet.getString(4))).
						setCalificacion(resultSet.getDouble(5)).setDescripcion(resultSet.getString(6)).
						setMateria(MateriaEntity.create().setIdentificador(resultSet.getObject(7, UUID.class)).
								setNombre(resultSet.getString(8)).setCreditos(resultSet.getInt(9)).setPeriodoAcademico(PeriodoAcademicoEntity.create().
						setIdentificador(resultSet.getObject(10, UUID.class)).setNombre(resultSet.getString(11)).
						setFechaInicio(resultSet.getObject(12, LocalDate.class)).setFechaFin(resultSet.getObject(13, LocalDate.class)).
						setTipoPeriodo(TipoPeriodoAcademicoEntity.create().setIdentificador(resultSet.getObject(14, UUID.class)).
								setNombre(resultSet.getString(15)).setDescripcion(resultSet.getString(16))).
						setEstado(EstadoPeriodoAcademicoEntity.create().setIdentificador(resultSet.getObject(17, UUID.class)).
								setNombre(resultSet.getString(18)).setDescripcion(resultSet.getString(19))).
						setEstudiante(EstudianteEntity.create().setIdentificador(resultSet.getObject(20, UUID.class)).
								setPrimerNombre(resultSet.getString(21)).setSegundoNombre(resultSet.getString(22)).setPrimerApellido(resultSet.getString(23)).
								setSegudoApellido(resultSet.getString(24)).setNumeroTelefonico(resultSet.getString(25)).setCorreo(resultSet.getString(26)).
								setFechaNacimiento(resultSet.getObject(27, LocalDate.class)).setTipoDocumento(TipoDocumentoEntity.create().
								setIdentificador(resultSet.getObject(28, UUID.class)).setNombre(resultSet.getString(29)).setDescripcion(resultSet.getString(30))).
								setNumeroDocumento(resultSet.getString(31)).setConfirmacionCorreo(RespuestaEntity.create().setIdentificador(resultSet.getObject(32, UUID.class)).
								setNombre(resultSet.getString(33)).setDescripcion(resultSet.getString(34))).setPais(PaisEntity.create().
								setIdentificador(resultSet.getObject(35, UUID.class)).setNombre(resultSet.getString(36))).
								setEstado(EstadoEstudianteEntity.create().setIdentificador(resultSet.getObject(37, UUID.class)).
								setNombre(resultSet.getString(38)).setDescripcion(resultSet.getString(39)))).setPromedioPeriodo(resultSet.getDouble(40))).
								setPromedioMateria(resultSet.getDouble(41))).setPorcentaje(resultSet.getDouble(42));
				result.add(entityTmp);
			}
			return result;
		} catch (final SQLException exception) {
			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE, NotaPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(NotaPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE, NotaPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		}
	}
}
