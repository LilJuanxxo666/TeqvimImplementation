package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EstadoEventoDAO;
import co.edu.uco.teqvim.entities.EstadoEventoEntity;

public final class EstadoEventoPostgreSqlDAO implements EstadoEventoDAO {

	public EstadoEventoPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public List<EstadoEventoEntity> read(EstadoEventoEntity entity) {
		return null;
	}

}
