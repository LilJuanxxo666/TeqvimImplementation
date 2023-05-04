package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;
import co.edu.uco.teqvim.entities.EstadoEventoEntity;

public interface EstadoEventoDAO {
	
	void create(EstadoEventoEntity entity);

	List<EstadoEventoEntity> read(EstadoEventoEntity entity);

}
