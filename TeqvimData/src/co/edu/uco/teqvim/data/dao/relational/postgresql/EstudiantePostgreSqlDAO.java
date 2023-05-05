package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EstudianteDAO;
import co.edu.uco.teqvim.entities.EstudianteEntity;

public final class EstudiantePostgreSqlDAO implements EstudianteDAO {

	public EstudiantePostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(EstudianteEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EstudianteEntity> read(EstudianteEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(EstudianteEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(EstudianteEntity entity) {
		// TODO Auto-generated method stub

	}

}
