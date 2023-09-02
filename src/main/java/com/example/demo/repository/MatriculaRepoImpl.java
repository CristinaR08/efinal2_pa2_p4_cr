package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional(value = TxType.REQUIRED)
@Repository
public class MatriculaRepoImpl implements IMatriculaRepo{

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Matricula> buscarTodos() {
		TypedQuery<Matricula> matriculas = this.entityManager.createQuery("SELECT ma FROM Matricula ma", Matricula.class);
		return matriculas.getResultList();
		
	}
	
}
