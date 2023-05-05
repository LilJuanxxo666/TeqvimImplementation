package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.TipoPeriodoAcademicoDAO;
import co.edu.uco.teqvim.entities.TipoPeriodoAcademicoEntity;

public final class TipoPeriodoAcademicoPostgreSqlDAO implements TipoPeriodoAcademicoDAO {

	public TipoPeriodoAcademicoPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(TipoPeriodoAcademicoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoPeriodoAcademicoEntity> read(TipoPeriodoAcademicoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
