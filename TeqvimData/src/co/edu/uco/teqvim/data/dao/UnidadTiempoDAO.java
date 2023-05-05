package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.UnidadTiempoEntity;

public interface UnidadTiempoDAO {

	void create(UnidadTiempoEntity entity);

	List<UnidadTiempoEntity> read(UnidadTiempoEntity entity);

}
