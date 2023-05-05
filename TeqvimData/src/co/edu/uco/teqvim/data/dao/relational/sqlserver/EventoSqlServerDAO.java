package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EventoDAO;
import co.edu.uco.teqvim.entities.EventoEntity;

public class EventoSqlServerDAO implements EventoDAO {

	public EventoSqlServerDAO(final Connection connection) {

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
