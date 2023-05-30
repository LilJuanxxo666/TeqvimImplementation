package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.NombreDiaSemanaEntity;

public interface NombreDiaSemanaDAO {

	List<NombreDiaSemanaEntity> read(NombreDiaSemanaEntity entity);
	
}
