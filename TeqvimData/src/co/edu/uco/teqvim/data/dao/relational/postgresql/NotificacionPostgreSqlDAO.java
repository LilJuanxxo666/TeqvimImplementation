package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.NotificacionDAO;
import co.edu.uco.teqvim.entities.NotificacionEntity;

public final class NotificacionPostgreSqlDAO implements NotificacionDAO {

	public NotificacionPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(NotificacionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<NotificacionEntity> read(NotificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(NotificacionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(NotificacionEntity entity) {
		// TODO Auto-generated method stub

	}

}
