package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.DuracionDAO;
import co.edu.uco.teqvim.entities.DuracionEntity;

public final class DuracionSqlServerDAO implements DuracionDAO {

	public DuracionSqlServerDAO(final Connection connection) {

	}

	@Override
	public void create(final DuracionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DuracionEntity> read(final DuracionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(final DuracionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(final DuracionEntity entity) {
		// TODO Auto-generated method stub

	}

}
