package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoNotificacionDAO;
import co.edu.uco.teqvim.entities.TipoNotificacionEntity;

public final class TipoNotificacionSqlServerDAO implements TipoNotificacionDAO {

	public TipoNotificacionSqlServerDAO(final Connection connection) {

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
