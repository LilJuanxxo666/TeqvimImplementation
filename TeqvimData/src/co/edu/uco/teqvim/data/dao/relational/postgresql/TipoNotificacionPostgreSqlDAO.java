package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoNotificacionDAO;
import co.edu.uco.teqvim.entities.TipoNotificacionEntity;

public final class TipoNotificacionPostgreSqlDAO implements TipoNotificacionDAO {

	public TipoNotificacionPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(TipoNotificacionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoNotificacionEntity> read(TipoNotificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
