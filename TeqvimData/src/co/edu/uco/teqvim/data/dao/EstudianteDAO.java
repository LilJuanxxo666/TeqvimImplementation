package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.EstudianteEntity;

public interface EstudianteDAO {
	
	void create(EstudianteEntity entity);

	List<EstudianteEntity> read(EstudianteEntity entity);

	void update(EstudianteEntity entity);

	void delete(EstudianteEntity entity);

}
