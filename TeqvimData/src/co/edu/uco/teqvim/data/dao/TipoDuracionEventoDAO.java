package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoDuracionEventoEntity;

public interface TipoDuracionEventoDAO {

	void create(TipoDuracionEventoEntity entity);

	List<TipoDuracionEventoEntity> read(TipoDuracionEventoEntity entity);

}
