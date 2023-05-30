package co.edu.uco.teqvim.business.facade;

import java.util.List;

import co.edu.uco.teqvim.dto.DiaSemanaDTO;

public interface DiaSemanaFacade {
	
	void register(DiaSemanaDTO dto);

	List<DiaSemanaDTO> list(DiaSemanaDTO dto);

	void modify(DiaSemanaDTO dto);

	void drop(DiaSemanaDTO dto);
	
}
