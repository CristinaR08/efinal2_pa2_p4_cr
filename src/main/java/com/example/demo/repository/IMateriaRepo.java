package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepo {
	
	public void insertar(Materia materia);
	public void actualizar(Materia materia);
	public Materia buscar(Integer id);
	public List<Materia> buscarTodos();
	
}
