package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoNotificacionEntity;

public interface TipoNotificacionDAO {

	List<TipoNotificacionEntity> read(TipoNotificacionEntity entity);

}
