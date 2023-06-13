package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.exception.TeqvimDataException;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilText;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EstudiantePostgresSqlDAOMessages;
import co.edu.uco.teqvim.crosscutting.utils.Messages.EventoPostgresSqlDAOMessages;
import co.edu.uco.teqvim.crosscutting.utils.UtilDate;
import co.edu.uco.teqvim.data.dao.EventoDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;
import co.edu.uco.teqvim.entities.EstudianteEntity;
import co.edu.uco.teqvim.entities.EventoEntity;
import co.edu.uco.teqvim.entities.PaisEntity;
import co.edu.uco.teqvim.entities.RespuestaEntity;
import co.edu.uco.teqvim.entities.TipoDocumentoEntity;

public class EventoPostgreSqlDAO extends SqlDAO<EventoEntity> implements EventoDAO {

	public EventoPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final EventoEntity entity) {

		var sqlStatement = "INSERT INTO evento (identificador, titulo, descripcion, fecha_inicio, fecha_fin, tipo_duracion, estado_evento, tipo_evento, estudiante) VALUES (?,?,?,?,?,?,?,?,?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setString(2, entity.getTitulo());
			preparedStatement.setString(3, entity.getDescripcion());
			preparedStatement.setObject(4, entity.getFechaInicio());
			preparedStatement.setObject(5, entity.getFechaFin());
			preparedStatement.setObject(6, entity.getDuracionEvento().getIdentificador());
			preparedStatement.setObject(7, entity.getEstado().getIdentificador());
			preparedStatement.setObject(8, entity.getTipoEvento().getIdentificador());
			preparedStatement.setObject(9, entity.getEstudiante().getIdentificador());
			
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {

			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(EstudiantePostgresSqlDAOMessages.CREATE_TECHNICAL_EXCEPTION_MESSAGE, EstudiantePostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public final List<EventoEntity> read(final EventoEntity entity) {
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
			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.READ_TECHNICAL_SQL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.READ_TECHNICAL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public final void update(final EventoEntity entity) {
		var sqlStatement = "UPDATE evento SET titulo=?, descripcion=?, fecha_inicio=?, fecha_fin=?, tipo_duracion=?, estado_evento=?, tipo_evento=?, estudiante=? WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setString(1, entity.getTitulo());
			preparedStatement.setString(2, entity.getDescripcion());
			preparedStatement.setObject(3, entity.getFechaInicio());
			preparedStatement.setObject(4, entity.getFechaFin());
			preparedStatement.setObject(5, entity.getDuracionEvento().getIdentificador());
			preparedStatement.setObject(6, entity.getEstado().getIdentificador());
			preparedStatement.setObject(7, entity.getTipoEvento().getIdentificador());
			preparedStatement.setObject(8, entity.getEstudiante().getIdentificador());
			preparedStatement.setObject(9, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public final void delete(final EventoEntity entity) {
		var sqlStatement = "DELETE FROM evento WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected final String prepareSelect() {
		return "SELECT EST.identificador, EST.primer_nombre, EST.segundo_nombre, EST.primer_apellido, EST.segundo_apellido, EST.numero_telefonico, EST.correo, EST.fecha_nacimiento, EST.tipo_documento, TDO.nombre, TDO.descripcion, EST.numero_documento, EST.confirmacion_correo, CCO.nombre, CCO.descripcion, EST.pais, PAI.nombre, EST.estado_estudiante, ES.nombre, ES.descripcion ";
	}

	@Override
	protected final String prepareFrom() {
		return "FROM estudiante EST JOIN tipo_documento TDO ON TDO.identificador = EST.tipo_documento JOIN respuesta CCO ON EST.confirmacion_correo = CCO.identificador JOIN pais PAI ON PAI.identificador = EST.pais JOIN estado_estudiante ES ON ES.identificador = EST.estado_estudiante ";
	}

	@Override
	protected final String prepareWhere(final EventoEntity entity, List<Object> parameters) {

		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());

		var setWhere = true;

		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getTitulo())) {
				parameters.add(entity.getTitulo());
				where.append(setWhere ? "WHERE " : "AND ").append("titulo=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("descripcion=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getFechaInicio())) {
				parameters.add(entity.getFechaInicio());
				where.append(setWhere ? "WHERE " : "AND ").append("fecha_inicio=? ");
				setWhere = false;
			}
			if (!UtilDate.isDefaultDateOrNull(entity.getFechaFin())) {
				parameters.add(entity.getFechaFin());
				where.append(setWhere ? "WHERE " : "AND ").append("fecha_fin=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getDuracionEvento().getIdentificador())) {
				parameters.add(entity.getDuracionEvento().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("tipo_duracion=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getEstado().getIdentificador())) {
				parameters.add(entity.getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("estado_estudiante=? ");
				setWhere = false;
			}
			if (!UtilObject.isNull(entity.getTipoEvento().getIdentificador())) {
				parameters.add(entity.getTipoEvento().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("tipo_evento=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getEstudiante().getIdentificador())) {
				parameters.add(entity.getEstudiante().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("estudiante=? ");
			}
		}
		return where.toString();
	}

	@Override
	protected final String prepareOrderBy() {
		return "ORDER BY nombre ASC";
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

			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {

			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected List<EventoEntity> executeQuery(PreparedStatement preparedStatement) {
		
		final List<EventoEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				var tipoDocumento = new TipoDocumentoEntity(resultSet.getObject(9, UUID.class), resultSet.getString(10), resultSet.getString(11));
				var confirmacionCorreo = new RespuestaEntity(resultSet.getObject(13, UUID.class), resultSet.getString(14), resultSet.getString(15));
				var pais = new PaisEntity(resultSet.getObject(16, UUID.class), resultSet.getString(17));
				var estadoEstudiante = new EstadoEstudianteEntity(resultSet.getObject(18, UUID.class), resultSet.getString(19), resultSet.getString(20));
				var estudiante = new EstudianteEntity(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				var entityTmp = new EventoEntity(null, null, null, null, null, null, null, null, null);
						//resultSet.getObject(1, UUID.class), resultSet.getString(2), resultSet.getString(3),
						//resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						//resultSet.getString(7), "", resultSet.getObject(8, LocalDate.class), tipoDocumento, resultSet.getString(12), confirmacionCorreo, pais, estadoEstudiante);
				
				result.add(entityTmp);
			}

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(EventoPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE, EventoPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		}
		return result;
	}

}
