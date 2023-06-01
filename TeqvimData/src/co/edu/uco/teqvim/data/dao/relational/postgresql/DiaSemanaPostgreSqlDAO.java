package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.teqvim.data.dao.DiaSemanaDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.DiaSemanaEntity;

public final class DiaSemanaPostgreSqlDAO extends SqlDAO<DiaSemanaPostgreSqlDAO> implements DiaSemanaDAO{
	
	public DiaSemanaPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(DiaSemanaEntity entity) {
		
	}

	@Override
	public List<DiaSemanaEntity> read(DiaSemanaEntity entity) {
		return null;
	}

	@Override
	public void update(DiaSemanaEntity entity) {
		
	}

	@Override
	public void delete(DiaSemanaEntity entity) {
		
	}

	@Override
	protected String prepareSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String prepareFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String prepareWhere(DiaSemanaPostgreSqlDAO entity, List<Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String prepareOrderBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setParameters(PreparedStatement preparedStatement, List<Object> parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<DiaSemanaPostgreSqlDAO> executeQuery(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}

}
