package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoNotaEntity;

public interface TipoNotaDAO {

	void create(TipoNotaEntity entity);

	List<TipoNotaEntity> read(TipoNotaEntity entity);

}
