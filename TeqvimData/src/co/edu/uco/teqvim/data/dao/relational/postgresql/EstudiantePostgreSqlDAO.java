package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.exception.TeqvimDataException;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudiantePostgresSqlDAOMessages;
import co.edu.uco.teqvim.data.dao.EstudianteDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;
import co.edu.uco.teqvim.entities.EstudianteEntity;
import co.edu.uco.teqvim.entities.PaisEntity;
import co.edu.uco.teqvim.entities.RespuestaEntity;
import co.edu.uco.teqvim.entities.TipoDocumentoEntity;

public final class EstudiantePostgreSqlDAO extends SqlDAO<EstudianteEntity> implements EstudianteDAO {

	public EstudiantePostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final EstudianteEntity entity) {

		var sqlStatement = "INSERT INTO estudiante (identificador, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, numero_telefonico, correo, contrasena, fecha_nacimiento, tipo_documento, numero_documento, confirmacion_correo, pais, estado_estudiante) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setString(2, entity.getPrimerNombre());
			preparedStatement.setString(3, entity.getSegundoNombre());
			preparedStatement.setString(4, entity.getPrimerApellido());
			preparedStatement.setString(5, entity.getSegudoApellido());
			preparedStatement.setString(6, entity.getNumeroTelefonico());
			preparedStatement.setString(7, entity.getCorreo());
			preparedStatement.setString(8, entity.getContrasena());
			preparedStatement.setObject(9, entity.getFechaNacimiento());
			preparedStatement.setObject(10, entity.getTipoDocumento().getIdentificador());
			preparedStatement.setString(11, entity.getNumeroDocumento());
			preparedStatement.setObject(12, entity.getConfirmacionCorreo().getIdentificador());
			preparedStatement.setObject(13, entity.getPais().getIdentificador());
			preparedStatement.setObject(14, entity.getEstado().getIdentificador());
			
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {

			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.CREATE_TECHNICAL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public final List<EstudianteEntity> read(final EstudianteEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();

		sqlStatement.append(prepareSelect());
		sqlStatement.append(prepareFrom());
		sqlStatement.append(prepareWhere(entity, parameters));
		sqlStatement.append(prepareOrderBy());

		try (var preaparedStatement = getConnection().prepareStatement(sqlStatement.toString())) {

			setParameters(preaparedStatement, parameters);
			
			return executeQuery(preaparedStatement);

		}catch (final TeqvimDataException exception) { 
			throw exception;
		}
		catch (final SQLException exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.READ_TECHNICAL_SQL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.READ_TECHNICAL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public final void update(final EstudianteEntity entity) {
		var sqlStatement = "UPDATE estudiante SET primer_nombre=?, segundo_nombre=?, primer_apellido=?, segundo_apellido=?, numero_telefonico=?, correo=?, contrasena=?, fecha_nacimiento=?, tipo_documento=?, numero_documento=?, confirmacion_correo=?, pais=?, estado_estudiante=? WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setString(1, entity.getPrimerNombre());
			preparedStatement.setString(2, entity.getSegundoNombre());
			preparedStatement.setString(3, entity.getPrimerApellido());
			preparedStatement.setString(4, entity.getSegudoApellido());
			preparedStatement.setString(5, entity.getNumeroTelefonico());
			preparedStatement.setString(6, entity.getCorreo());
			preparedStatement.setString(7, entity.getContrasena());
			preparedStatement.setObject(8, entity.getFechaNacimiento());
			preparedStatement.setObject(9, entity.getTipoDocumento());
			preparedStatement.setString(10, entity.getNumeroDocumento());
			preparedStatement.setObject(11, entity.getConfirmacionCorreo());
			preparedStatement.setObject(12, entity.getPais());
			preparedStatement.setObject(13, entity.getEstado());
			preparedStatement.setObject(14, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public final void delete(final EstudianteEntity entity) {
		var sqlStatement = "DELETE FROM estudiante WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected final String prepareSelect() {
		return "SELECT EST.identificador, EST.primer_nombre, EST.segundo_nombre, EST.primer_apellido, EST.segundo_apellido, EST.numero_telefonico, EST.correo, \r\n"
				+ "EST.fecha_nacimiento, EST.tipo_documento, TDO.nombre, TDO.descripcion, EST.numero_documento, EST.confirmacion_correo, CCO.nombre, CCO.descripcion, EST.pais, \r\n"
				+ "PAI.nombre, EST.estado_estudiante, ES.nombre, ES.descripcion ";
	}

	@Override
	protected final String prepareFrom() {
		return "FROM estudiante EST JOIN tipo_documento TDO ON TDO.identificador = EST.tipo_documento JOIN respuesta CCO\r\n"
				+ "ON EST.confirmacion_correo = CCO.identificador JOIN pais PAI ON PAI.identificador = EST.pais JOIN estado_estudiante ES ON\r\n"
				+ "ES.identificador = EST.estado_estudiante ";
	}

	@Override
	protected final String prepareWhere(final EstudianteEntity entity, List<Object> parameters) {

		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());

		var setWhere = true;

		if (UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPrimerNombre())) {
				parameters.add(entity.getPrimerNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("primer_nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getSegundoNombre())) {
				parameters.add(entity.getSegundoNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("segundo_nombre=? ");
			}
			if (!UtilText.getUtilText().isEmpty(entity.getPrimerApellido())) {
				parameters.add(entity.getPrimerApellido());
				where.append(setWhere ? "WHERE " : "AND ").append("primer_apellido=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getSegudoApellido())) {
				parameters.add(entity.getPrimerApellido());
				where.append(setWhere ? "WHERE " : "AND ").append("segundo_apellido=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getNumeroTelefonico())) {
				parameters.add(entity.getNumeroTelefonico());
				where.append(setWhere ? "WHERE " : "AND ").append("numero_telefonico=? ");
			}
			if (!UtilText.getUtilText().isEmpty(entity.getCorreo())) {
				parameters.add(entity.getCorreo());
				where.append(setWhere ? "WHERE " : "AND ").append("correo=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getCorreo())) {
				parameters.add(entity.getCorreo());
				where.append(setWhere ? "WHERE " : "AND").append("contrasena=? ");
				setWhere = false;
			}
			if (!UtilObject.isNull(entity.getFechaNacimiento())) {
				parameters.add(entity.getFechaNacimiento());
				where.append(setWhere ? "WHERE " : "AND").append("fecha_nacimiento=? ");
			}
			if (!UtilUUID.isDefault(entity.getTipoDocumento().getIdentificador())) {
				parameters.add(entity.getTipoDocumento().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND").append("tipo_documento=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getNumeroDocumento())) {
				parameters.add(entity.getNumeroDocumento());
				where.append(setWhere ? "WHERE " : "AND").append("numero_documento=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getConfirmacionCorreo().getIdentificador())) {
				parameters.add(entity.getConfirmacionCorreo().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND").append("confirmacion_correo=? ");
			}
			if (!UtilUUID.isDefault(entity.getPais().getIdentificador())) {
				parameters.add(entity.getPais().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND").append("pais=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getEstado().getIdentificador())) {
				parameters.add(entity.getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND").append("estado_estudiante=? ");
				setWhere = false;
			}
		}
		return where.toString();
	}

	@Override
	protected final String prepareOrderBy() {
		return "ORDER BY primer_nombre ASC";
	}

	@Override
	protected final void setParameters(final PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			if (!UtilObject.isNull(parameters) && !UtilObject.isNull(preparedStatement)) {
				for (int i = 0; i < parameters.size(); i++) {
					preparedStatement.setObject(i + 1, parameters.get(i));
				}
			}
		} catch (final SQLException exception) {

			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {

			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected List<EstudianteEntity> executeQuery(PreparedStatement preparedStatement) {
		
		final List<EstudianteEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				var tipoDocumento = new TipoDocumentoEntity(resultSet.getObject(9, UUID.class), resultSet.getString(10), resultSet.getString(11));
				var confirmacionCorreo = new RespuestaEntity(resultSet.getObject(13, UUID.class), resultSet.getString(14), resultSet.getString(15));
				var pais = new PaisEntity(resultSet.getObject(16, UUID.class), resultSet.getString(17));
				var estadoEstudiante = new EstadoEstudianteEntity(resultSet.getObject(18, UUID.class), resultSet.getString(19), resultSet.getString(20));
				var entityTmp = new EstudianteEntity(
						resultSet.getObject(1, UUID.class), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7), "", resultSet.getObject(8, LocalDate.class), tipoDocumento, resultSet.getString(12), confirmacionCorreo, pais, estadoEstudiante);
				
				result.add(entityTmp);
			}

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		}
		return result;
	}

}
