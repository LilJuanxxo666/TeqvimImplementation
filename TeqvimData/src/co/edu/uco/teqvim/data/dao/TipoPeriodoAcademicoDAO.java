package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoPeriodoAcademicoEntity;

public interface TipoPeriodoAcademicoDAO {
	
	void create(TipoPeriodoAcademicoEntity entity);

	List<TipoPeriodoAcademicoEntity> read(TipoPeriodoAcademicoEntity entity);

}
