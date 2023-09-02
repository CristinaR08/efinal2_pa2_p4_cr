package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepo;
import com.example.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepo materiaRepo;
	
	@Override
	public void insertar(Materia materia) {
		this.materiaRepo.insertar(materia);
		
	}

	@Override
	public void actualizar(Materia materia) {
		this.materiaRepo.actualizar(materia);
		
	}

	@Override
	public Materia buscarId(Integer id) {
		return this.materiaRepo.buscar(id);
	}

	@Override
	public List<Materia> listaMaterias() {
		return this.materiaRepo.buscarTodos();
	}

}