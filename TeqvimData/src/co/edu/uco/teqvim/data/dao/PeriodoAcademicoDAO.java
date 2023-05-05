package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.PeriodoAcademicoEntity;

public interface PeriodoAcademicoDAO {
	
	void create(PeriodoAcademicoEntity entity);

	List<PeriodoAcademicoEntity> read(PeriodoAcademicoEntity entity);

	void update(PeriodoAcademicoEntity entity);

	void delete(PeriodoAcademicoEntity entity);

}
