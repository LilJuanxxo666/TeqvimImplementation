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
import co.edu.uco.teqvim.crosscutting.utils.Messages.TipoFestivoFijoPostgresSqlDAOMessages;
import co.edu.uco.teqvim.data.dao.TipoFestivoFijoDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.TipoFestivoFijoEntity;

public final class TipoFestivoFijoPostgreSqlDAO extends SqlDAO<TipoFestivoFijoEntity> implements TipoFestivoFijoDAO {

	public TipoFestivoFijoPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<TipoFestivoFijoEntity> read(TipoFestivoFijoEntity entity) {
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
			throw TeqvimDataException.create(TipoFestivoFijoPostgresSqlDAOMessages.READ_TECHNICAL_SQL_EXCEPTION_MESSAGE, TipoFestivoFijoPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE,exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(TipoFestivoFijoPostgresSqlDAOMessages.READ_TECHNICAL_EXCEPTION_MESSAGE, TipoFestivoFijoPostgresSqlDAOMessages.READ_EXCEPTION_USER_MESSAGE,exception);
		}
	}

	@Override
	protected String prepareSelect() {
		return "SELECT identificador, nombre, descripcion ";
	}

	@Override
	protected String prepareFrom() {
		return "FROM tipo_festivo_fijo ";
	}

	@Override
	protected String prepareWhere(TipoFestivoFijoEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());

		var setWhere = true;

		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("nombre=? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("descripcion LIKE %?% ");
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
			throw TeqvimDataException.create(TipoFestivoFijoPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_SQL_EXCEPTION_MESSAGE, TipoFestivoFijoPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(TipoFestivoFijoPostgresSqlDAOMessages.SET_PARAMETERS_TECHNICAL_EXCEPTION_MESSAGE, TipoFestivoFijoPostgresSqlDAOMessages.SET_PARAMETERS_EXCEPTION_USER_MESSAGE, exception);
		}
	}

	@Override
	protected List<TipoFestivoFijoEntity> executeQuery(PreparedStatement preparedStatement) {

		final List<TipoFestivoFijoEntity> result = new ArrayList<>();

		try (var resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {

				var entityTmp = TipoFestivoFijoEntity.create().setIdentificador(resultSet.getObject(1, UUID.class))
						.setNombre(resultSet.getString(2)).setDescripcion(resultSet.getString(3));

				result.add(entityTmp);
			}
		} catch (final SQLException exception) {
			throw TeqvimDataException.create(TipoFestivoFijoPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_SQL_EXCEPTION_MESSAGE, TipoFestivoFijoPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimDataException.create(TipoFestivoFijoPostgresSqlDAOMessages.EXECUTE_QUERY_TECHNICAL_EXCEPTION_MESSAGE, TipoFestivoFijoPostgresSqlDAOMessages.EXECUTE_QUERY_EXCEPTION_USER_MESSAGE, exception);
		}
		return result;
	}
}
