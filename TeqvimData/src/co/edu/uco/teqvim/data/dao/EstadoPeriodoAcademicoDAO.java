package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.EstadoPeriodoAcademicoEntity;

public interface EstadoPeriodoAcademicoDAO {

	void create(EstadoPeriodoAcademicoEntity entity);

	List<EstadoPeriodoAcademicoEntity> read(EstadoPeriodoAcademicoEntity entity);

}
