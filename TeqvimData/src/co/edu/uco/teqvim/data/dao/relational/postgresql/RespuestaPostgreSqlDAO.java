package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.RespuestaDAO;
import co.edu.uco.teqvim.entities.RespuestaEntity;

public final class RespuestaPostgreSqlDAO implements RespuestaDAO {

	public RespuestaPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(RespuestaEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RespuestaEntity> read(RespuestaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
