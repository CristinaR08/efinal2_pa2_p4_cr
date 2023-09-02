package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional(value = TxType.REQUIRED)
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo{

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante buscar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante> listaEstudiantes = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		return listaEstudiantes.getResultList();
		
	}
	
}
