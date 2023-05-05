package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.PaisEntity;

public interface PaisDAO {

	void create(PaisEntity entity);

	List<PaisEntity> read(PaisEntity entity);

}
