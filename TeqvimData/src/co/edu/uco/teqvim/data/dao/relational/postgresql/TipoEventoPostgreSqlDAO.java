package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoEventoDAO;
import co.edu.uco.teqvim.entities.TipoEventoEntity;

public final class TipoEventoPostgreSqlDAO implements TipoEventoDAO {

	public TipoEventoPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(TipoEventoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoEventoEntity> read(TipoEventoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
