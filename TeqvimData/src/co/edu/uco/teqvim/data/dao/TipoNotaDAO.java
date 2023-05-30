package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoNotaEntity;

public interface TipoNotaDAO {

	List<TipoNotaEntity> read(TipoNotaEntity entity);

}
