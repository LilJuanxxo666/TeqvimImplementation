package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.NotaEntity;

public interface NotaDAO {
	
	void create(NotaEntity entity);

	List<NotaEntity> read(NotaEntity entity);

	void update(NotaEntity entity);

	void delete(NotaEntity entity);

}
