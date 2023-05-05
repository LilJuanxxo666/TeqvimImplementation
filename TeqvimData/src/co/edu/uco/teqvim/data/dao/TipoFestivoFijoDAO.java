package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoFestivoFijoEntity;

public interface TipoFestivoFijoDAO {

	void create(TipoFestivoFijoEntity entity);

	List<TipoFestivoFijoEntity> read(TipoFestivoFijoEntity entity);

}
