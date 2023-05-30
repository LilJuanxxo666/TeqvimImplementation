package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.PaisDAO;
import co.edu.uco.teqvim.entities.PaisEntity;

public final class PaisSqlServerDAO implements PaisDAO {

	public PaisSqlServerDAO(final Connection connection) {

	}
	
	@Override
	public List<PaisEntity> read(PaisEntity entity) {
		return null;
	}

}
