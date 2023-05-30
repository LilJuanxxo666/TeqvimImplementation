package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EstadoNotificacionDAO;
import co.edu.uco.teqvim.entities.EstadoNotificacionEntity;

public final class EstadoNotificacionSqlServerDAO implements EstadoNotificacionDAO {

	public EstadoNotificacionSqlServerDAO(final Connection connection) {

	}

	@Override
	public List<EstadoNotificacionEntity> read(EstadoNotificacionEntity entity) {
		return null;
	}

}
