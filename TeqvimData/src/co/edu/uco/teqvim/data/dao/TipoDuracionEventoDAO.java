package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoDuracionEventoEntity;

public interface TipoDuracionEventoDAO {

	List<TipoDuracionEventoEntity> read(TipoDuracionEventoEntity entity);

}
