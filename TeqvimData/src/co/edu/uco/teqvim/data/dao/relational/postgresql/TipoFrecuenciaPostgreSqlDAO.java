package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoFrecuenciaDAO;
import co.edu.uco.teqvim.entities.TipoFrecuenciaEntity;

public final class TipoFrecuenciaPostgreSqlDAO implements TipoFrecuenciaDAO {

	public TipoFrecuenciaPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public List<TipoFrecuenciaEntity> read(TipoFrecuenciaEntity entity) {
		return null;
	}

}
