package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.UnidadTiempoDAO;
import co.edu.uco.teqvim.entities.UnidadTiempoEntity;

public final class UnidadTiempoPostgreSqlDAO implements UnidadTiempoDAO {

	public UnidadTiempoPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(UnidadTiempoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UnidadTiempoEntity> read(UnidadTiempoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
