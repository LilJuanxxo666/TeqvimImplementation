package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.NotaDAO;
import co.edu.uco.teqvim.entities.NotaEntity;

public final class NotaSqlServerDAO implements NotaDAO {

	public NotaSqlServerDAO(final Connection connection) {

	}

	@Override
	public void create(NotaEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<NotaEntity> read(NotaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(NotaEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(NotaEntity entity) {
		// TODO Auto-generated method stub

	}

}
