package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.RespuestaDAO;
import co.edu.uco.teqvim.entities.RespuestaEntity;

public final class RespuestaSqlServerDAO implements RespuestaDAO {

	public RespuestaSqlServerDAO(final Connection connection) {

	}

	@Override
	public List<RespuestaEntity> read(RespuestaEntity entity) {
		return null;
	}

}
