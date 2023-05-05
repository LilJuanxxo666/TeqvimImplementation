package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.FestivoEntity;

public interface FestivoDAO {
	
	void create(FestivoEntity entity);

	List<FestivoEntity> read(FestivoEntity entity);

	void update(FestivoEntity entity);

	void delete(FestivoEntity entity);

}
