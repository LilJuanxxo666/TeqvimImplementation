package co.edu.uco.teqvim.business.facade;

import java.util.List;
import co.edu.uco.teqvim.dto.RepeticionDTO;

public interface RepeticionFacade {

	void register(RepeticionDTO dto);

	List<RepeticionDTO> list(RepeticionDTO dto);

	void modify(RepeticionDTO dto);

	void drop(RepeticionDTO dto);

}
