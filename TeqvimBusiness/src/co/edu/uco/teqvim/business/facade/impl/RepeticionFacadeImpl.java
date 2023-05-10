package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;
import co.edu.uco.teqvim.dto.RepeticionDTO;

public final class RepeticionFacadeImpl {

	void register(RepeticionDTO dto);

	List<RepeticionDTO> list(RepeticionDTO dto);

	void modify(RepeticionDTO dto);

	void drop(RepeticionDTO dto);

}
