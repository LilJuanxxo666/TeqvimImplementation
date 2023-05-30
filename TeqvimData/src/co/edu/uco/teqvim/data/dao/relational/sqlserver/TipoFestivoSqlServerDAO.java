package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoFestivoDAO;
import co.edu.uco.teqvim.entities.TipoFestivoEntity;

public final class TipoFestivoSqlServerDAO implements TipoFestivoDAO {

	public TipoFestivoSqlServerDAO(final Connection connection) {

	}
	
	@Override
	public List<TipoFestivoEntity> read(TipoFestivoEntity entity) {
		return null;
	}

}
