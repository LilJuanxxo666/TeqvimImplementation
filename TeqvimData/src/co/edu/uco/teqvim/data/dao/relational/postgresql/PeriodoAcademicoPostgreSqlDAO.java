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
import co.edu.uco.teqvim.crosscutting.utils.Messages.PeriodoAcademicoPostgresSqlDAOMessages;
import co.edu.uco.teqvim.data.dao.PeriodoAcademicoDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;
import co.edu.uco.teqvim.entities.EstadoPeriodoAcademicoEntity;
import co.edu.uco.teqvim.entities.EstudianteEntity;
import co.edu.uco.teqvim.entities.PaisEntity;
import co.edu.uco.teqvim.entities.PeriodoAcademicoEntity;
import co.edu.uco.teqvim.entities.RespuestaEntity;
import co.edu.uco.teqvim.entities.TipoDocumentoEntity;
import co.edu.uco.teqvim.entities.TipoPeriodoAcademicoEntity;

public final class PeriodoAcademicoPostgreSqlDAO extends SqlDAO<PeriodoAcademicoEntity> implements PeriodoAcademicoDAO {

	public PeriodoAcademicoPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(PeriodoAcademicoEntity entity) {
		var sqlStatement = "INSERT INTO periodo_academico (identificador, nombre, fecha_inicio, fecha_fin, tipo_periodo_academico, estado_periodo_academico, estudiante, promedio_periodo) VALUES (?,?,?,?,?,?,?,?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setString(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getFechaInicio());
			preparedStatement.setObject(4, entity.getFechaFin());
			preparedStatement.setObject(5, entity.getTipoPeriodo().getIdentificador());
			preparedStatement.setObject(6, entity.getEstado().getIdentificador());
			preparedStatement.setObject(7, entity.getEstudiante().getIdentificador());
			preparedStatement.setObject(8, entity.getPromedioPeriodo());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {

			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.CREATE_TECHNICAL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public List<PeriodoAcademicoEntity> read(PeriodoAcademicoEntity entity) {
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
			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.READ_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.READ_TECHNICAL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public void update(PeriodoAcademicoEntity entity) {
		var sqlStatement = "UPDATE periodo_academico SET nombre=?, fecha_inicio=?, fecha_fin=?, tipo_periodo_academico=?, estado_periodo_academico=?, estudiante=?, promedio_periodo=? WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setString(1, entity.getNombre());
			preparedStatement.setObject(2, entity.getFechaInicio());
			preparedStatement.setObject(3, entity.getFechaFin());
			preparedStatement.setObject(4, entity.getTipoPeriodo().getIdentificador());
			preparedStatement.setObject(5, entity.getEstado().getIdentificador());
			preparedStatement.setObject(6, entity.getEstudiante().getIdentificador());
			preparedStatement.setObject(7, entity.getPromedioPeriodo());
			preparedStatement.setObject(8, entity.getIdentificador());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public void delete(PeriodoAcademicoEntity entity) {
		var sqlStatement = "DELETE FROM periodo_academico WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected String prepareSelect() {
		return "SELECT PEA.identificador, PEA.nombre, PEA.fecha_inicio, PEA.fecha_fin, PEA.tipo_periodo_academico, TPA.nombre, TPA.descripcion, PEA.estado_periodo_academico, EPA.nombre, EPA.descripcion, PEA.estudiante, EST.primer_nombre, EST.segundo_nombre, EST.primer_apellido, EST.segundo_apellido, EST.numero_telefonico, EST.correo, EST.fecha_nacimiento, EST.tipo_documento, TDO.nombre, TDO.descripcion, EST.numero_documento, EST.confirmacion_correo, CCO.nombre, CCO.descripcion, EST.pais, PAI.nombre, EST.estado_estudiante, ES.nombre, ES.descripcion, PEA.promedio_periodo ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM periodo_academico PEA JOIN tipo_periodo_academico TPA ON TPA.identificador = PEA.tipo_periodo_academico JOIN estado_periodo_academico EPA ON EPA.identificador = PEA.estado_periodo_academico JOIN estudiante EST ON EST.identificador = PEA.estudiante JOIN tipo_documento TDO ON TDO.identificador = EST.tipo_documento JOIN respuesta CCO ON EST.confirmacion_correo = CCO.identificador JOIN pais PAI ON PAI.identificador = EST.pais JOIN estado_estudiante ES ON ES.identificador = EST.estado_estudiante ";
	}

	@Override
	protected String prepareWhere(PeriodoAcademicoEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		var setWhere = true;

		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE PEA.identificador=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.nombre=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getFechaInicio())) {
				parameters.add(entity.getFechaInicio());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.fecha_inicio=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getFechaFin())) {
				parameters.add(entity.getFechaFin());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.fecha_fin=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getTipoPeriodo().getIdentificador())) {
				parameters.add(entity.getTipoPeriodo().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.tipo_periodo_academico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getTipoPeriodo().getNombre())) {
				parameters.add(entity.getTipoPeriodo().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("TPA.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getTipoPeriodo().getDescripcion())) {
				parameters.add(entity.getTipoPeriodo().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("TPA.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getEstado().getIdentificador())) {
				parameters.add(entity.getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.estado_periodo_academico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstado().getNombre())) {
				parameters.add(entity.getEstado().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("EPA.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstado().getDescripcion())) {
				parameters.add(entity.getEstado().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("EPA.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getPrimerNombre())) {
				parameters.add(entity.getEstudiante().getPrimerNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.primer_nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getSegundoNombre())) {
				parameters.add(entity.getEstudiante().getSegundoNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.segundo_nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getPrimerApellido())) {
				parameters.add(entity.getEstudiante().getPrimerApellido());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.primer_apellido=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getSegudoApellido())) {
				parameters.add(entity.getEstudiante().getPrimerApellido());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.segundo_apellido=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getNumeroTelefonico())) {
				parameters.add(entity.getEstudiante().getNumeroTelefonico());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.numero_telefonico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getCorreo())) {
				parameters.add(entity.getEstudiante().getCorreo());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.correo=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getEstudiante().getFechaNacimiento())) {
				parameters.add(entity.getEstudiante().getFechaNacimiento());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.fecha_nacimiento=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getEstudiante().getTipoDocumento().getIdentificador())) {
				parameters.add(entity.getEstudiante().getTipoDocumento().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.tipo_documento=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getTipoDocumento().getNombre())) {
				parameters.add(entity.getEstudiante().getTipoDocumento().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("TDO.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getTipoDocumento().getDescripcion())) {
				parameters.add(entity.getEstudiante().getTipoDocumento().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("TDO.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getNumeroDocumento())) {
				parameters.add(entity.getEstudiante().getNumeroDocumento());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.numero_documento=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getEstudiante().getConfirmacionCorreo().getIdentificador())) {
				parameters.add(entity.getEstudiante().getConfirmacionCorreo().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.confirmacion_correo=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getConfirmacionCorreo().getNombre())) {
				parameters.add(entity.getEstudiante().getConfirmacionCorreo().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("CCO.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getConfirmacionCorreo().getDescripcion())) {
				parameters.add(entity.getEstudiante().getConfirmacionCorreo().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("CCO.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getEstudiante().getPais().getIdentificador())) {
				parameters.add(entity.getEstudiante().getPais().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.pais=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getPais().getNombre())) {
				parameters.add(entity.getEstudiante().getPais().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("PAI.nombre=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getEstudiante().getEstado().getIdentificador())) {
				parameters.add(entity.getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.estado_estudiante=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getEstado().getNombre())) {
				parameters.add(entity.getEstado().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("ES.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getEstudiante().getEstado().getDescripcion())) {
				parameters.add(entity.getEstudiante().getEstado().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("ES.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilNumber.getUtilNumber().isZero(entity.getPromedioPeriodo())) {
				parameters.add(entity.getPromedioPeriodo());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.promedio_periodo=? ");
			}
		}
		return where.toString();
	}

	@Override
	protected String prepareOrderBy() {
		return "ORDER BY PEA.nombre ASC";
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
					PeriodoAcademicoPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(
					PeriodoAcademicoPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE,
					PeriodoAcademicoPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected List<PeriodoAcademicoEntity> executeQuery(PreparedStatement preparedStatement) {
		
		final List<PeriodoAcademicoEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				PeriodoAcademicoEntity entityTmp = PeriodoAcademicoEntity.create().
						setIdentificador(resultSet.getObject(1, UUID.class)).setNombre(resultSet.getString(2)).
						setFechaInicio(resultSet.getObject(3, LocalDate.class)).setFechaFin(resultSet.getObject(4, LocalDate.class)).
						setTipoPeriodo(TipoPeriodoAcademicoEntity.create().setIdentificador(resultSet.getObject(5, UUID.class)).
								setNombre(resultSet.getString(6)).setDescripcion(resultSet.getString(7))).
						setEstado(EstadoPeriodoAcademicoEntity.create().setIdentificador(resultSet.getObject(8, UUID.class)).
								setNombre(resultSet.getString(9)).setDescripcion(resultSet.getString(10))).
						setEstudiante(EstudianteEntity.create().setIdentificador(resultSet.getObject(11, UUID.class)).
								setPrimerNombre(resultSet.getString(12)).setSegundoNombre(resultSet.getString(13)).setPrimerApellido(resultSet.getString(14)).
								setSegudoApellido(resultSet.getString(15)).setNumeroTelefonico(resultSet.getString(16)).setCorreo(resultSet.getString(17)).
								setFechaNacimiento(resultSet.getObject(18, LocalDate.class)).setTipoDocumento(TipoDocumentoEntity.create().
								setIdentificador(resultSet.getObject(19, UUID.class)).setNombre(resultSet.getString(20)).setDescripcion(resultSet.getString(21))).
								setNumeroDocumento(resultSet.getString(22)).setConfirmacionCorreo(RespuestaEntity.create().setIdentificador(resultSet.getObject(23, UUID.class)).
								setNombre(resultSet.getString(24)).setDescripcion(resultSet.getString(25))).setPais(PaisEntity.create().
								setIdentificador(resultSet.getObject(26, UUID.class)).setNombre(resultSet.getString(27))).
								setEstado(EstadoEstudianteEntity.create().setIdentificador(resultSet.getObject(28, UUID.class)).
								setNombre(resultSet.getString(29)).setDescripcion(resultSet.getString(30)))).setPromedioPeriodo(resultSet.getDouble(31));
				result.add(entityTmp);
			}
			return result;
		} catch (final SQLException exception) {
			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE, PeriodoAcademicoPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(PeriodoAcademicoPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE, PeriodoAcademicoPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		}
	}
}
