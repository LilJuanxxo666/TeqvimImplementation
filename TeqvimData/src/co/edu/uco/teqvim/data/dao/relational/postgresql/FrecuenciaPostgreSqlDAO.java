package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.FrecuenciaDAO;
import co.edu.uco.teqvim.entities.FrecuenciaEntity;

public final class FrecuenciaPostgreSqlDAO implements FrecuenciaDAO {

	public FrecuenciaPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(FrecuenciaEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FrecuenciaEntity> read(FrecuenciaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(FrecuenciaEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(FrecuenciaEntity entity) {
		// TODO Auto-generated method stub

	}

}
