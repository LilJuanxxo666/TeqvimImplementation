package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoFestivoEntity;

public interface TipoFestivoDAO {
	
	void create(TipoFestivoEntity entity);

	List<TipoFestivoEntity> read(TipoFestivoEntity entity);

}
