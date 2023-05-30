package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoPeriodoAcademicoDAO;
import co.edu.uco.teqvim.entities.TipoPeriodoAcademicoEntity;

public final class TipoPeriodoAcademicoPostgreSqlDAO implements TipoPeriodoAcademicoDAO {

	public TipoPeriodoAcademicoPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public List<TipoPeriodoAcademicoEntity> read(TipoPeriodoAcademicoEntity entity) {
		return null;
	}

}
