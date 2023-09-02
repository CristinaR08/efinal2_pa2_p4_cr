package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.IMatriculaRepo;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional(value = TxType.REQUIRED)
@Repository
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepo matriculaRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Matricula matricula) {
		this.matriculaRepo.insertar(matricula);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Matricula> listaMatriculas() {
		return this.matriculaRepo.buscarTodos();
		
	}
	
}
