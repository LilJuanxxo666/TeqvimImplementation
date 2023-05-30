package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoEventoDAO;
import co.edu.uco.teqvim.entities.TipoEventoEntity;

public final class TipoEventoPostgreSqlDAO implements TipoEventoDAO {

	public TipoEventoPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public List<TipoEventoEntity> read(TipoEventoEntity entity) {
		return null;
	}

}
