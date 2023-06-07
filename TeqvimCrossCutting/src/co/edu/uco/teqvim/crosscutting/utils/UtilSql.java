package co.edu.uco.teqvim.crosscutting.utils;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.teqvim.crosscutting.exception.TeqvimCrossCuttingException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.UtilSqlMessages;

public final class UtilSql {

	private UtilSql() {
		super();
	}

	public static boolean connectionIsOpen(final Connection connection) {
		if (UtilObject.isNull(connection)) {
			throw TeqvimCrossCuttingException.create(UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION, UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE);
		}
		try {
			return !connection.isClosed();
		} catch (final SQLException exception) {
			throw TeqvimCrossCuttingException.create(UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION, UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimCrossCuttingException.create(UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION, UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE, exception);
		}

	}

	public static final void closeConnection(final Connection connection) {
		try {
			if (connectionIsOpen(connection)) {
				connection.close();
			}
		} catch (final TeqvimCrossCuttingException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw TeqvimCrossCuttingException.create(UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION, UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimCrossCuttingException.create(UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION, UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE, exception);
		}

	}

	public static final boolean initCommitIsReady(final Connection connection) {

		try {
			if (connection.getAutoCommit()) {
				throw TeqvimCrossCuttingException.create(UtilSqlMessages.COMMIT_IS_STARTED_TECHNICAL_AUTOCOMMIT, UtilSqlMessages.COMMIT_IS_STARTED_USER_MESSAGE);
			}
			return !connection.getAutoCommit();
		} catch (TeqvimCrossCuttingException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw TeqvimCrossCuttingException.create(UtilSqlMessages.COMMIT_IS_STARTED_TECHNICAL_SQL_EXCEPTION, UtilSqlMessages.COMMIT_IS_STARTED_USER_MESSAGE, exception);
		} catch (final Exception exception) {
			throw TeqvimCrossCuttingException.create(UtilSqlMessages.COMMIT_IS_STARTED_TECHNICAL_EXCEPTION, UtilSqlMessages.COMMIT_IS_STARTED_USER_MESSAGE, exception);
		}
	}

}
