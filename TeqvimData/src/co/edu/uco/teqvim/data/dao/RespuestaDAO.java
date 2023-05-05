package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.RespuestaEntity;

public interface RespuestaDAO {

	void create(RespuestaEntity entity);

	List<RespuestaEntity> read(RespuestaEntity entity);

}
