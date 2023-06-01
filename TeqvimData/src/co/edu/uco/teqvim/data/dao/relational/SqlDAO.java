package co.edu.uco.teqvim.data.dao.relational;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.teqvim.crosscutting.exception.TeqvimDataException;
import co.edu.uco.teqvim.crosscutting.utils.Messages.SqlDAOMessages;
import co.edu.uco.teqvim.crosscutting.utils.UtilSql;

public abstract class SqlDAO<E> {
		
		private Connection connection;
		
		protected SqlDAO(Connection connection) {
			setConnection(connection);
		}
		
		protected Connection getConnection() {
			return connection;
		}
		
		private final void setConnection(final Connection connection) {
			if(!UtilSql.connectionIsOpen(connection)) {
				var userMessage = SqlDAOMessages.USER_MESSAGE;
				var technicalMessage = SqlDAOMessages.TECHNICAL_MESSAGE;
				throw TeqvimDataException.create(technicalMessage, userMessage);
			}
			this.connection = connection; 
		}
		
		protected abstract String prepareSelect();
		
		protected abstract String prepareFrom();
		
		protected abstract String prepareWhere(E entity, List<Object> parameters);
		
		protected abstract String prepareOrderBy();
		
		protected abstract void setParameters(PreparedStatement preparedStatement, List<Object> parameters);
		
		protected abstract List<E> executeQuery(PreparedStatement preparedStatement);
}
