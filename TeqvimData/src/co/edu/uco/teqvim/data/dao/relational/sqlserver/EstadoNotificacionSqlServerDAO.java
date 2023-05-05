package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EstadoNotificacionDAO;
import co.edu.uco.teqvim.entities.EstadoNotificacionEntity;

public final class EstadoNotificacionSqlServerDAO implements EstadoNotificacionDAO {

	public EstadoNotificacionSqlServerDAO(final Connection connection) {

	}

	@Override
	public void create(EstadoNotificacionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EstadoNotificacionEntity> read(EstadoNotificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
