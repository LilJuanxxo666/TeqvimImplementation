package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;
import co.edu.uco.teqvim.dto.MateriaDTO;

public final class MateriaFacadeImpl {

	void register(MateriaDTO dto);

	List<MateriaDTO> list(MateriaDTO dto);

	void modify(MateriaDTO dto);

	void drop(MateriaDTO dto);

}
