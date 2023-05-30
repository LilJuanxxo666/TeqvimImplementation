package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoNotaDAO;
import co.edu.uco.teqvim.entities.TipoNotaEntity;

public final class TipoNotaSqlServerDAO implements TipoNotaDAO {

	public TipoNotaSqlServerDAO(final Connection connection) {

	}

	@Override
	public List<TipoNotaEntity> read(TipoNotaEntity entity) {
		return null;
	}

}
