package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoEventoEntity;

public interface TipoEventoDAO {

	List<TipoEventoEntity> read(TipoEventoEntity entity);

}
