package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.EventoEntity;

public interface EventoDAO {

	void create(EventoEntity entity);

	List<EventoEntity> read(EventoEntity entity);

	void update(EventoEntity entity);

	void delete(EventoEntity entity);

}
