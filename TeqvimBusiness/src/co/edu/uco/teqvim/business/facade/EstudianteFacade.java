package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.EstudianteDTO;

public interface EstudianteFacade {

	void register(EstudianteDTO dto);

	List<EstudianteDTO> list(EstudianteDTO dto);

	void modify(EstudianteDTO dto);

	void drop(EstudianteDTO dto);

}
