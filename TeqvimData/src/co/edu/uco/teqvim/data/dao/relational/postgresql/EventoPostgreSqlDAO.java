package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EventoDAO;
import co.edu.uco.teqvim.entities.EventoEntity;

public class EventoPostgreSqlDAO implements EventoDAO {

	public EventoPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(EventoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EventoEntity> read(EventoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(EventoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(EventoEntity entity) {
		// TODO Auto-generated method stub

	}

}
