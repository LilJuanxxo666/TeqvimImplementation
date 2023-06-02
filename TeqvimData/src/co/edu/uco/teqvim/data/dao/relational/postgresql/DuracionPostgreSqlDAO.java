package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.teqvim.crosscutting.exception.TeqvimDataException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.DuracionPostgresSqlDAOMessages;
import co.edu.uco.teqvim.crosscutting.utils.UtilNumber;
import co.edu.uco.teqvim.crosscutting.utils.UtilObject;
import co.edu.uco.teqvim.crosscutting.utils.UtilUUID;
import co.edu.uco.teqvim.data.dao.DuracionDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.DuracionEntity;
import co.edu.uco.teqvim.entities.UnidadTiempoEntity;

public final class DuracionPostgreSqlDAO extends SqlDAO<DuracionEntity> implements DuracionDAO {

	public DuracionPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final DuracionEntity entity) {

		var sqlStatement = "INSERT INTO duracion (identificador, cantidad_tiempo, unidad_tiempo) VALUES (?,?,?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setInt(2, entity.getCantidadTiempo());
			preparedStatement.setObject(3, entity.getUnidadTiempo().getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {

			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.CREATE_TECHNICAL_SQL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.CREATE_TECHNICAL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.CREATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public final List<DuracionEntity> read(final DuracionEntity entity) {
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
			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.READ_TECHNICAL_SQL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.READ_TECHNICAL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public final void update(final DuracionEntity entity) {
		var sqlStatement = "UPDATE duracion SET cantidad_tiempo=?, unidad_tiempo=? WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setInt(1, entity.getCantidadTiempo());
			preparedStatement.setObject(2, entity.getUnidadTiempo().getIdentificador());
			preparedStatement.setObject(3, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	public final void delete(final DuracionEntity entity) {
		var sqlStatement = "DELETE FROM duracion WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdentificador());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.UPDATE_TECHNICAL_SQL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.UPDATE_TECHNICAL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.UPDATE_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected final String prepareSelect() {
		return "SELECT DU.identificador, DU.cantidad_tiempo, DU.unidad_tiempo, UN.nombre ";
	}

	@Override
	protected final String prepareFrom() {
		return "FROM duracion DU JOIN unidad_tiempo UN ON UN.identificador = DU.unidad_tiempo ";
	}

	@Override
	protected final String prepareWhere(final DuracionEntity entity, List<Object> parameters) {

		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());

		var setWhere = true;

		if (UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=? ");
				setWhere = false;
			}
			if (!UtilNumber.getUtilNumber().isNull(entity.getCantidadTiempo())) {
				parameters.add(entity.getCantidadTiempo());
				where.append(setWhere ? "WHERE " : "AND ").append("cantidad_tiempo=? ");
				setWhere = false;
			}
			if (!UtilUUID.isDefault(entity.getUnidadTiempo().getIdentificador())) {
				parameters.add(entity.getUnidadTiempo().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("unidad_tiempo=? ");
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

			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {

			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected List<DuracionEntity> executeQuery(PreparedStatement preparedStatement) {
		
		final List<DuracionEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				var unidadTiempo = new UnidadTiempoEntity(resultSet.getObject(3, UUID.class), resultSet.getString(4));
				var entityTmp = new DuracionEntity(resultSet.getObject(1, UUID.class), resultSet.getInt(2), unidadTiempo);
				result.add(entityTmp);
			}

		} catch (final SQLException exception) {
			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(DuracionPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE, DuracionPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		}
		return result;
	}

}
