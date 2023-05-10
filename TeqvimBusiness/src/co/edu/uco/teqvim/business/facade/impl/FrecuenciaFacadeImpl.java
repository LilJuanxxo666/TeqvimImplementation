package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;
import co.edu.uco.teqvim.dto.FrecuenciaDTO;

public final class FrecuenciaFacadeImpl {

	void register(FrecuenciaDTO dto);

	List<FrecuenciaDTO> list(FrecuenciaDTO dto);

	void modify(FrecuenciaDTO dto);

	void drop(FrecuenciaDTO dto);

}
