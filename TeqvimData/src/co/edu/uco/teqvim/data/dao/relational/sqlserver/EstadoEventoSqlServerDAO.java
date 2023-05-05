package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EstadoEventoDAO;
import co.edu.uco.teqvim.entities.EstadoEventoEntity;

public final class EstadoEventoSqlServerDAO implements EstadoEventoDAO {

	public EstadoEventoSqlServerDAO(final Connection connection) {

	}

	@Override
	public void create(EstadoEventoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EstadoEventoEntity> read(EstadoEventoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
