package co.edu.uco.teqvim.data.dao;

import java.util.List;

import co.edu.uco.teqvim.entities.TipoDocumentoEntity;

public interface TipoDocumentoDAO {
	
	void create(TipoDocumentoEntity entity);

	List<TipoDocumentoEntity> read(TipoDocumentoEntity entity);

}
