package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.EstadoNotificacionEntity;

public interface EstadoNotificacionDAO {

	List<EstadoNotificacionEntity> read(EstadoNotificacionEntity entity);

}
