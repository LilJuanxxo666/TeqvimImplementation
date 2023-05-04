package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;

public interface EstadoEstudianteDAO {

	void create(EstadoEstudianteEntity entity);

	List<EstadoEstudianteEntity> read(EstadoEstudianteEntity entity);

}
