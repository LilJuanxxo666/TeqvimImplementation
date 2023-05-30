package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoDuracionEventoDAO;
import co.edu.uco.teqvim.entities.TipoDuracionEventoEntity;

public final class TipoDuracionEventoSqlServerDAO implements TipoDuracionEventoDAO {

	public TipoDuracionEventoSqlServerDAO(final Connection connection) {

	}

	@Override
	public List<TipoDuracionEventoEntity> read(TipoDuracionEventoEntity entity) {
		return null;
	}

}
