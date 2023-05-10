package co.edu.uco.teqvim.business.facade.impl;

import java.util.List;
import co.edu.uco.teqvim.dto.FestivoDTO;

public final class FestivoFacadeImpl {

	void register(FestivoDTO dto);

	List<FestivoDTO> list(FestivoDTO dto);

	void modify(FestivoDTO dto);

	void drop(FestivoDTO dto);

}
