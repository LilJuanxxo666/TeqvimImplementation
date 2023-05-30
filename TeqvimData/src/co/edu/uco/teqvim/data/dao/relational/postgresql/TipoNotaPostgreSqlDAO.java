package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoNotaDAO;
import co.edu.uco.teqvim.entities.TipoNotaEntity;

public final class TipoNotaPostgreSqlDAO implements TipoNotaDAO {

	public TipoNotaPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public List<TipoNotaEntity> read(TipoNotaEntity entity) {
		return null;
	}

}
