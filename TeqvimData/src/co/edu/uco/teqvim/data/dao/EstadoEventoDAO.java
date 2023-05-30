package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.EstadoEventoEntity;

public interface EstadoEventoDAO {

	List<EstadoEventoEntity> read(EstadoEventoEntity entity);

}
