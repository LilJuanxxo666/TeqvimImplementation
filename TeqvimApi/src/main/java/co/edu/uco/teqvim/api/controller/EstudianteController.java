package co.edu.uco.teqvim.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.teqvim.dto.EstudianteDTO;

@RestController
@RequestMapping("teqvim/api/v1/estudiante")
public final class EstudianteController {
	
	@GetMapping
	public EstudianteDTO test() {
		return EstudianteDTO.create();
	}
}
