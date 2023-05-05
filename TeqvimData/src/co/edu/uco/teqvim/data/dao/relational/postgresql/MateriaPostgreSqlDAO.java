package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.MateriaDAO;
import co.edu.uco.teqvim.entities.MateriaEntity;

public final class MateriaPostgreSqlDAO implements MateriaDAO {

	public MateriaPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(MateriaEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MateriaEntity> read(MateriaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MateriaEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MateriaEntity entity) {
		// TODO Auto-generated method stub

	}

}
