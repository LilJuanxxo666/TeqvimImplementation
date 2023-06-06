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
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION;

			throw TeqvimCrossCuttingException.create(technicalMessage, userMessage);
		}

		try {
			return !connection.isClosed();
		} catch (final SQLException exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION;

			throw TeqvimCrossCuttingException.create(technicalMessage, userMessage, exception);
		} catch (final Exception exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION;

			throw TeqvimCrossCuttingException.create(technicalMessage, userMessage, exception);
		}

	}

	public static final void closeConnection(final Connection connection) {
		try {
			if (!connectionIsOpen(connection)) {
				connection.close();
			}
		} catch (final TeqvimCrossCuttingException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION;

			throw TeqvimCrossCuttingException.create(technicalMessage, userMessage, exception);
		} catch (final Exception exception) {
			var userMessage = UtilSqlMessages.CONNECTION_IS_OPEN_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION;

			throw TeqvimCrossCuttingException.create(technicalMessage, userMessage, exception);
		}

	}

	public static final boolean initCommitIsReady(final Connection connection) {

		try {
			if (connection.getAutoCommit()) {
				var userMessage = UtilSqlMessages.COMMIT_IS_STARTED_USER_MESSAGE;
				var technicalMessage = UtilSqlMessages.COMMIT_IS_STARTED_TECHNICAL_AUTOCOMMIT;
				throw TeqvimCrossCuttingException.create(technicalMessage, userMessage);
			}
			return !connection.getAutoCommit();
		} catch (TeqvimCrossCuttingException exception) {
			throw exception;
		} catch (SQLException exception) {
			var userMessage = UtilSqlMessages.COMMIT_IS_STARTED_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.COMMIT_IS_STARTED_TECHNICAL_SQL_EXCEPTION;

			throw TeqvimCrossCuttingException.create(technicalMessage, userMessage, exception);
		} catch (final Exception exception) {
			var userMessage = UtilSqlMessages.COMMIT_IS_STARTED_USER_MESSAGE;
			var technicalMessage = UtilSqlMessages.COMMIT_IS_STARTED_TECHNICAL_EXCEPTION;

			throw TeqvimCrossCuttingException.create(userMessage, technicalMessage, exception);
		}
	}

}
