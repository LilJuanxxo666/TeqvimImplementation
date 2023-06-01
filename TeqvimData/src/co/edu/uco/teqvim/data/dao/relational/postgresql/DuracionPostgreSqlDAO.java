package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.teqvim.data.dao.DuracionDAO;
import co.edu.uco.teqvim.data.dao.relational.SqlDAO;
import co.edu.uco.teqvim.entities.DuracionEntity;

public final class DuracionPostgreSqlDAO extends SqlDAO<DuracionEntity> implements DuracionDAO {

	public DuracionPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(DuracionEntity entity) {
		
	}

	@Override
	public List<DuracionEntity> read(DuracionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DuracionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(DuracionEntity entity) {
		// TODO Auto-generated method stub

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
	protected String prepareWhere(DuracionEntity entity, List<Object> parameters) {
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
	protected List<DuracionEntity> executeQuery(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}

}
