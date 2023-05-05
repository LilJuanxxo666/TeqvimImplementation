package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.DuracionEntity;

public interface DuracionDAO {
	
	void create(DuracionEntity entity);

	List<DuracionEntity> read(DuracionEntity entity);

	void update(DuracionEntity entity);

	void delete(DuracionEntity entity);

}
