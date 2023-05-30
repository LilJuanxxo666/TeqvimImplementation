package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoFestivoDAO;
import co.edu.uco.teqvim.entities.TipoFestivoEntity;

public final class TipoFestivoPostgreSqlDAO implements TipoFestivoDAO {

	public TipoFestivoPostgreSqlDAO(final Connection connection) {

	}
	@Override
	public List<TipoFestivoEntity> read(TipoFestivoEntity entity) {
		return null;
	}

}
