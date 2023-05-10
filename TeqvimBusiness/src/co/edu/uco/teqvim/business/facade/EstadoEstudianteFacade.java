package co.edu.uco.teqvim.business.facade;

import java.util.List;

import co.edu.uco.teqvim.dto.EstadoEstudianteDTO;

public interface EstadoEstudianteFacade {

	void register(EstadoEstudianteDTO dto);

	List<EstadoEstudianteDTO> list(EstadoEstudianteDTO dto);

}
