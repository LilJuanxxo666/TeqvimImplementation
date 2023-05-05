package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EstadoPeriodoAcademicoDAO;
import co.edu.uco.teqvim.entities.EstadoPeriodoAcademicoEntity;

public final class EstadoPeriodoAcademicoPostgreSqlDAO implements EstadoPeriodoAcademicoDAO {

	public EstadoPeriodoAcademicoPostgreSqlDAO(final Connection connection) {

	}

	@Override
	public void create(EstadoPeriodoAcademicoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EstadoPeriodoAcademicoEntity> read(EstadoPeriodoAcademicoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
