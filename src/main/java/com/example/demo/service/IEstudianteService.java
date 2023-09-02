package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {

	public void guardar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscarId(Integer id);
	public List<Estudiante> listaEstudiantes();
}
