package co.edu.uco.teqvim.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.EstadoEstudianteDAO;
import co.edu.uco.teqvim.entities.EstadoEstudianteEntity;

public final class EstadoEstudiantePostgreSqlDAO implements EstadoEstudianteDAO {

	public EstadoEstudiantePostgreSqlDAO(final Connection connection) {

	}

	@Override
	public List<EstadoEstudianteEntity> read(EstadoEstudianteEntity entity) {
		return null;
	}

}
