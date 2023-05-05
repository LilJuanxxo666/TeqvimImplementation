package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.DuracionDAO;
import co.edu.uco.teqvim.entities.DuracionEntity;

public final class DuracionPostgreSqlDAO implements DuracionDAO {

	public DuracionPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(DuracionEntity entity) {
		// TODO Auto-generated method stub

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

}
