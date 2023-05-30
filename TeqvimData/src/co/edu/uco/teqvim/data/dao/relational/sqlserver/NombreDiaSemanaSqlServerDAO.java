package co.edu.uco.teqvim.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.teqvim.data.dao.NombreDiaSemanaDAO;
import co.edu.uco.teqvim.entities.NombreDiaSemanaEntity;

public final class NombreDiaSemanaSqlServerDAO implements NombreDiaSemanaDAO{
	
	public NombreDiaSemanaSqlServerDAO(final Connection connection) {

	}

	@Override
	public List<NombreDiaSemanaEntity> read(NombreDiaSemanaEntity entity) {
		return null;
	}

}
