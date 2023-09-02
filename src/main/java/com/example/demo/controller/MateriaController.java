package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping("/buscar")
	public String buscarMaterias(Model modelo) {
		List<Materia> listaMaterias = this.materiaService.listaMaterias();
		modelo.addAttribute("materias", listaMaterias);
		return "vistaListaMaterias";
	}
	
	@PostMapping("/guardar")
	public String insertarMaterias(Materia materia) {
		this.materiaService.insertar(materia);
		return "redirect:/materias/nuevo";
	}
	
	@GetMapping("/nuevo")
	public String nuevaMateria(Materia materia) {
		return "vistaNuevaMateria";
		
	}
	
}
