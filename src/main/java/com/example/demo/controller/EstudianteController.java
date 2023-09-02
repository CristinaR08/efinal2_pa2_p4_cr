package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	//http://localhost:8080/UCE/estudiantes/buscar
	@GetMapping("/buscar")
	public String buscarEstudiantes(Model modelo) {
		List<Estudiante> listaEstudiante = this.estudianteService.listaEstudiantes();
		modelo.addAttribute("estudiantes",listaEstudiante);
		return "vistaListaEstudiantes";
	}

	@PostMapping("/guardar")
	public String ingresarEstudiante(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "redirect:/estudiantes/nuevo";
	}
	
	@GetMapping("/nuevo")
	public String nuevoEstudiante(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
		
	}	
}
