package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.RepeticionDAO;
import co.edu.uco.teqvim.entities.RepeticionEntity;

public final class RepeticionPostgreSqlDAO implements RepeticionDAO {

	public RepeticionPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(RepeticionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RepeticionEntity> read(RepeticionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RepeticionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(RepeticionEntity entity) {
		// TODO Auto-generated method stub

	}

}
