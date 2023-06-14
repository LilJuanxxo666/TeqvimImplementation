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
import co.edu.uco.teqvim.crosscutting.utils.Messages.MateriaPostgresSqlDAOMessages;
import co.edu.uco.teqvim.data.dao.MateriaDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;
import co.edu.uco.teqvim.entities.EstadoPeriodoAcademicoEntity;
import co.edu.uco.teqvim.entities.EstudianteEntity;
import co.edu.uco.teqvim.entities.MateriaEntity;
import co.edu.uco.teqvim.entities.PaisEntity;
import co.edu.uco.teqvim.entities.PeriodoAcademicoEntity;
import co.edu.uco.teqvim.entities.RespuestaEntity;
import co.edu.uco.teqvim.entities.TipoDocumentoEntity;
import co.edu.uco.teqvim.entities.TipoPeriodoAcademicoEntity;

public final class MateriaPostgreSqlDAO extends SqlDAO<MateriaEntity> implements MateriaDAO {

	public MateriaPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(MateriaEntity entity) {
		var sqlStatement = "INSERT INTO materia (identificador, nombre, creditos, periodo_academico, promedio_materia) VALUES (?,?,?,?,?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setString(2, entity.getNombre());
			preparedStatement.setInt(3, entity.getCreditos());
			preparedStatement.setObject(4, entity.getPeriodoAcademico().getIdentificador());
			preparedStatement.setDouble(5, entity.getPromedioMateria());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {

			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.CREATE_TECHNICAL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public List<MateriaEntity> read(MateriaEntity entity) {
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
			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.READ_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.READ_TECHNICAL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public void update(MateriaEntity entity) {
		var sqlStatement = "UPDATE materia SET nombre=?, creditos=?, periodo_academico=?, promedio_materia=? WHERE identificador = ?";
		
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setString(2, entity.getNombre());
			preparedStatement.setInt(3, entity.getCreditos());
			preparedStatement.setObject(4, entity.getPeriodoAcademico());
			preparedStatement.setDouble(5, entity.getPromedioMateria());
			preparedStatement.setObject(5, entity.getIdentificador());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}

	}

	@Override
	public void delete(MateriaEntity entity) {
		var sqlStatement = "DELETE FROM materia WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected String prepareSelect() {
		return "SELECT MAT.identificador, MAT.nombre, MAT.creditos, MAT.periodo_academico, PEA.nombre, PEA.fecha_inicio, PEA.fecha_fin, PEA.tipo_periodo_academico, TPA.nombre, TPA.descripcion, PEA.estado_periodo_academico, EPA.nombre, EPA.descripcion, PEA.estudiante, EST.primer_nombre, EST.segundo_nombre, EST.primer_apellido, EST.segundo_apellido, EST.numero_telefonico, EST.correo, EST.fecha_nacimiento, EST.tipo_documento, TDO.nombre, TDO.descripcion, EST.numero_documento, EST.confirmacion_correo, CCO.nombre, CCO.descripcion, EST.pais, PAI.nombre, EST.estado_estudiante, ES.nombre, ES.descripcion, PEA.promedio_periodo, MAT.promedio_materia ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM materia MAT JOIN periodo_academico PEA ON PEA.identificador = MAT.periodo_academico JOIN tipo_periodo_academico TPA ON TPA.identificador = PEA.tipo_periodo_academico JOIN estado_periodo_academico EPA ON EPA.identificador = PEA.estado_periodo_academico JOIN estudiante EST ON EST.identificador = PEA.estudiante JOIN tipo_documento TDO ON TDO.identificador = EST.tipo_documento JOIN respuesta CCO ON EST.confirmacion_correo = CCO.identificador JOIN pais PAI ON PAI.identificador = EST.pais JOIN estado_estudiante ES ON ES.identificador = EST.estado_estudiante ";
	}

	@Override
	protected String prepareWhere(MateriaEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		var setWhere = true;

		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE MAT.identificador=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("MAT.nombre=? ");
				setWhere = false;
			}
			if (!UtilNumber.getUtilNumber().isZero(entity.getCreditos())) {
				parameters.add(entity.getCreditos());
				where.append(setWhere ? "WHERE " : "AND ").append("MAT.creditos=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getPeriodoAcademico().getIdentificador())) {
				parameters.add(entity.getPeriodoAcademico().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("MAT.periodo_academico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getNombre())) {
				parameters.add(entity.getPeriodoAcademico().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.nombre=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getPeriodoAcademico().getFechaInicio())) {
				parameters.add(entity.getPeriodoAcademico().getFechaInicio());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.fecha_inicio=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getPeriodoAcademico().getFechaFin())) {
				parameters.add(entity.getPeriodoAcademico().getFechaFin());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.fecha_fin=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getPeriodoAcademico().getTipoPeriodo().getIdentificador())) {
				parameters.add(entity.getPeriodoAcademico().getTipoPeriodo().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.tipo_periodo_academico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getTipoPeriodo().getNombre())) {
				parameters.add(entity.getPeriodoAcademico().getTipoPeriodo().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("TPA.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getTipoPeriodo().getDescripcion())) {
				parameters.add(entity.getPeriodoAcademico().getTipoPeriodo().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("TPA.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getPeriodoAcademico().getEstado().getIdentificador())) {
				parameters.add(entity.getPeriodoAcademico().getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.estado_periodo_academico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstado().getNombre())) {
				parameters.add(entity.getPeriodoAcademico().getEstado().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("EPA.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstado().getDescripcion())) {
				parameters.add(entity.getPeriodoAcademico().getEstado().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("EPA.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getPrimerNombre())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getPrimerNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.primer_nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getSegundoNombre())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getSegundoNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.segundo_nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getPrimerApellido())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getPrimerApellido());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.primer_apellido=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getSegudoApellido())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getPrimerApellido());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.segundo_apellido=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getNumeroTelefonico())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getNumeroTelefonico());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.numero_telefonico=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getCorreo())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getCorreo());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.correo=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getPeriodoAcademico().getEstudiante().getFechaNacimiento())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getFechaNacimiento());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.fecha_nacimiento=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getPeriodoAcademico().getEstudiante().getTipoDocumento().getIdentificador())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getTipoDocumento().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.tipo_documento=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getTipoDocumento().getNombre())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getTipoDocumento().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("TDO.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getTipoDocumento().getDescripcion())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getTipoDocumento().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("TDO.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getNumeroDocumento())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getNumeroDocumento());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.numero_documento=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getIdentificador())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.confirmacion_correo=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getNombre())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("CCO.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getDescripcion())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getConfirmacionCorreo().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("CCO.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getPeriodoAcademico().getEstudiante().getPais().getIdentificador())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getPais().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.pais=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getPais().getNombre())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getPais().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("PAI.nombre=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getPeriodoAcademico().getEstudiante().getEstado().getIdentificador())) {
				parameters.add(entity.getPeriodoAcademico().getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("EST.estado_estudiante=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getEstado().getNombre())) {
				parameters.add(entity.getPeriodoAcademico().getEstado().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("ES.nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPeriodoAcademico().getEstudiante().getEstado().getDescripcion())) {
				parameters.add(entity.getPeriodoAcademico().getEstudiante().getEstado().getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("ES.descripcion LIKE %?% ");
				setWhere = false;
			}
			if (!UtilNumber.getUtilNumber().isZero(entity.getPeriodoAcademico().getPromedioPeriodo())) {
				parameters.add(entity.getPeriodoAcademico().getPromedioPeriodo());
				where.append(setWhere ? "WHERE " : "AND ").append("PEA.promedio_periodo=? ");
				setWhere = false;
			}
			if (!UtilNumber.getUtilNumber().isZero(entity.getPromedioMateria())) {
				parameters.add(entity.getPromedioMateria());
				where.append(setWhere ? "WHERE " : "AND ").append("MAT.promedio_materia=? ");
			}
		}
		return where.toString();
	}

	@Override
	protected String prepareOrderBy() {
		return "ORDER BY MAT.nombre ASC";
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
					MateriaPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(
					MateriaPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE,
					MateriaPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected List<MateriaEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<MateriaEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				MateriaEntity entityTmp = MateriaEntity.create().setIdentificador(resultSet.getObject(1, UUID.class)).setNombre(resultSet.getString(2)).setCreditos(resultSet.getInt(3)).setPeriodoAcademico(PeriodoAcademicoEntity.create().
						setIdentificador(resultSet.getObject(4, UUID.class)).setNombre(resultSet.getString(5)).
						setFechaInicio(resultSet.getObject(6, LocalDate.class)).setFechaFin(resultSet.getObject(7, LocalDate.class)).
						setTipoPeriodo(TipoPeriodoAcademicoEntity.create().setIdentificador(resultSet.getObject(8, UUID.class)).
								setNombre(resultSet.getString(9)).setDescripcion(resultSet.getString(10))).
						setEstado(EstadoPeriodoAcademicoEntity.create().setIdentificador(resultSet.getObject(11, UUID.class)).
								setNombre(resultSet.getString(12)).setDescripcion(resultSet.getString(13))).
						setEstudiante(EstudianteEntity.create().setIdentificador(resultSet.getObject(14, UUID.class)).
								setPrimerNombre(resultSet.getString(15)).setSegundoNombre(resultSet.getString(16)).setPrimerApellido(resultSet.getString(17)).
								setSegudoApellido(resultSet.getString(18)).setNumeroTelefonico(resultSet.getString(19)).setCorreo(resultSet.getString(20)).
								setFechaNacimiento(resultSet.getObject(21, LocalDate.class)).setTipoDocumento(TipoDocumentoEntity.create().
								setIdentificador(resultSet.getObject(22, UUID.class)).setNombre(resultSet.getString(23)).setDescripcion(resultSet.getString(24))).
								setNumeroDocumento(resultSet.getString(25)).setConfirmacionCorreo(RespuestaEntity.create().setIdentificador(resultSet.getObject(26, UUID.class)).
								setNombre(resultSet.getString(27)).setDescripcion(resultSet.getString(28))).setPais(PaisEntity.create().
								setIdentificador(resultSet.getObject(29, UUID.class)).setNombre(resultSet.getString(30))).
								setEstado(EstadoEstudianteEntity.create().setIdentificador(resultSet.getObject(31, UUID.class)).
								setNombre(resultSet.getString(32)).setDescripcion(resultSet.getString(33)))).setPromedioPeriodo(resultSet.getDouble(34))).setPromedioMateria(resultSet.getDouble(35));
				result.add(entityTmp);
			}
			return result;
		} catch (final SQLException exception) {
			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE, MateriaPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(MateriaPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE, MateriaPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		}
	}

}
