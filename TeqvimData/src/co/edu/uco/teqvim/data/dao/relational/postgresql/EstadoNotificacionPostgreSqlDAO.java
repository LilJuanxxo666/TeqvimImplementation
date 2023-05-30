package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EstadoNotificacionDAO;
import co.edu.uco.teqvim.entities.EstadoNotificacionEntity;

public final class EstadoNotificacionPostgreSqlDAO implements EstadoNotificacionDAO {

	public EstadoNotificacionPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public List<EstadoNotificacionEntity> read(EstadoNotificacionEntity entity) {
		return null;
	}

}
