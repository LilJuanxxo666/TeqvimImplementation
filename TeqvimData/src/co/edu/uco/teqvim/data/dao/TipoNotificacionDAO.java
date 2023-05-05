package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoNotificacionEntity;

public interface TipoNotificacionDAO {

	void create(TipoNotificacionEntity entity);

	List<TipoNotificacionEntity> read(TipoNotificacionEntity entity);

}
