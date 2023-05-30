package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.DiaSemanaEntity;

public interface DiaSemanaDAO {

	void create(DiaSemanaEntity entity);

	List<DiaSemanaEntity> read(DiaSemanaEntity entity);

	void update(DiaSemanaEntity entity);

	void delete(DiaSemanaEntity entity);

}
