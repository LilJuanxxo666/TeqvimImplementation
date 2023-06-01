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
import co.edu.uco.teqvim.crosscutting.utils.Messages.TipoDuracionEventoPostgresSqlDAOMessages;
import co.edu.uco.teqvim.data.dao.TipoDuracionEventoDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.TipoDuracionEventoEntity;

public final class TipoDuracionEventoPostgreSqlDAO extends SqlDAO<TipoDuracionEventoEntity> implements TipoDuracionEventoDAO {

	public TipoDuracionEventoPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<TipoDuracionEventoEntity> read(TipoDuracionEventoEntity entity) {
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
			throw TeqvimDataException.create(TipoDuracionEventoPostgresSqlDAOMessages.READ_TECHNICAL_SQL_EXCEPTION_MESSAGE, TipoDuracionEventoPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE,exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(TipoDuracionEventoPostgresSqlDAOMessages.READ_TECHNICAL_EXCEPTION_MESSAGE, TipoDuracionEventoPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE,exception);
		}
	}

	@Override
	protected String prepareSelect() {
		return "SELECT identificador, nombre, descripcion ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM tipo_duracion_evento ";
	}

	@Override
	protected String prepareWhere(TipoDuracionEventoEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());

		var setWhere = true;

		if (UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND").append("nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE " : "AND").append("descripcion LIKE %?% ");
			}
		}
		return where.toString();
	}

	@Override
	protected String prepareOrderBy() {
		return "ORDER BY nombre ASC";
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
			throw TeqvimDataException.create(TipoDuracionEventoPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE, TipoDuracionEventoPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);

		} catch (final Exception exception) {
			throw TeqvimDataException.create(TipoDuracionEventoPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE, TipoDuracionEventoPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected List<TipoDuracionEventoEntity> executeQuery(PreparedStatement preparedStatement) {

		final List<TipoDuracionEventoEntity> result = new ArrayList<>();

		try (var resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {

				var entityTmp = new TipoDuracionEventoEntity(resultSet.getObject("identificador", UUID.class),
						resultSet.getString("nombre"), resultSet.getString("descripcion"));

				result.add(entityTmp);
			}
		} catch (final SQLException exception) {
			throw TeqvimDataException.create(TipoDuracionEventoPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE, TipoDuracionEventoPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(TipoDuracionEventoPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE, TipoDuracionEventoPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		}
		return result;
	}
}
