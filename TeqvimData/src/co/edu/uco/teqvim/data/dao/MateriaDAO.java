package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.MateriaEntity;

public interface MateriaDAO {

	void create(MateriaEntity entity);

	List<MateriaEntity> read(MateriaEntity entity);

	void update(MateriaEntity entity);

	void delete(MateriaEntity entity);

}
