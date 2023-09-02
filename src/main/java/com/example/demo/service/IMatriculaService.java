package com.example.demo.service;
import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	
	public void guardar(Matricula estudiante);
	public List<Matricula> listaMatriculas();
	
}
