package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoEventoDAO;
import co.edu.uco.teqvim.entities.TipoEventoEntity;

public final class TipoEventoSqlServerDAO implements TipoEventoDAO {

	public TipoEventoSqlServerDAO(final Connection connection) {

	}

	@Override
	public List<TipoEventoEntity> read(TipoEventoEntity entity) {
		return null;
	}

}
