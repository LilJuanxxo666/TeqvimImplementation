package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.NotificacionEntity;

public interface NotificacionDAO {
	
	void create(NotificacionEntity entity);

	List<NotificacionEntity> read(NotificacionEntity entity);

	void update(NotificacionEntity entity);

	void delete(NotificacionEntity entity);

}
