package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService matriculaService;
	
	@GetMapping("/buscar")
	public String buscarMatriculas(Model modelo) {
		List<Matricula> listaMatriculas = this.matriculaService.listaMatriculas();
		modelo.addAttribute("materias", listaMatriculas);
		return "vistaListaMatriculas";
	}
	
	@PostMapping("/guardar")
	public String insertarMatriculas(Matricula matricula) {
		this.matriculaService.guardar(matricula);
		return "redirect:/matriculas/nuevo";
	}
	
	@GetMapping("/nuevo")
	public String nuevaMatricula(Matricula matricula) {
		return "vistaNuevaMatricula";
		
	}
	
}
