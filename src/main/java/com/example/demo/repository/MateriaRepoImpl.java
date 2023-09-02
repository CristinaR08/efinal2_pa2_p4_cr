package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepoImpl implements IMateriaRepo{

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
		
	}

	@Override
	public void actualizar(Materia materia) {
		this.entityManager.merge(materia);
		
	}

	@Override
	public Materia buscar(Integer id) {
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public List<Materia> buscarTodos() {
		TypedQuery<Materia> listaMaterias = this.entityManager.createQuery("SELECT m FROM Materia m", Materia.class);
		return listaMaterias.getResultList();
	}
	
	
	
}
