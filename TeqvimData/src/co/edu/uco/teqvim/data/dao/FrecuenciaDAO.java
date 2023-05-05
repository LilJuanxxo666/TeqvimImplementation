package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.FrecuenciaEntity;

public interface FrecuenciaDAO {
	
	void create(FrecuenciaEntity entity);

	List<FrecuenciaEntity> read(FrecuenciaEntity entity);

	void update(FrecuenciaEntity entity);

	void delete(FrecuenciaEntity entity);

}
