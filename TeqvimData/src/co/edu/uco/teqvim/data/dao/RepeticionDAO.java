package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.RepeticionEntity;

public interface RepeticionDAO {

	void create(RepeticionEntity entity);

	List<RepeticionEntity> read(RepeticionEntity entity);

	void update(RepeticionEntity entity);

	void delete(RepeticionEntity entity);

}
