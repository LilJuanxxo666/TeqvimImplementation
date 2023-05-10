package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;
import co.edu.uco.teqvim.dto.EstudianteDTO;

public final class EstudianteFacadeImpl {

	void register(EstudianteDTO dto);

	List<EstudianteDTO> list(EstudianteDTO dto);

	void modify(EstudianteDTO dto);

	void drop(EstudianteDTO dto);

}
