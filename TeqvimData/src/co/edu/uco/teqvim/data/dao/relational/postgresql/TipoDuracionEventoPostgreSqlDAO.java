package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoDuracionEventoDAO;
import co.edu.uco.teqvim.entities.TipoDuracionEventoEntity;

public final class TipoDuracionEventoPostgreSqlDAO implements TipoDuracionEventoDAO {

	public TipoDuracionEventoPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(TipoDuracionEventoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoDuracionEventoEntity> read(TipoDuracionEventoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
