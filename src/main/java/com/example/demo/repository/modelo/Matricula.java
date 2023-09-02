package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@SequenceGenerator(name = "seq_matricula",sequenceName = "seq_matricula",allocationSize = 1)
	@GeneratedValue(generator = "seq_matricula",strategy = GenerationType.SEQUENCE)
	@Column(name = "matr_id")
	private Integer id;
	
	@Column(name = "matr_fecha")
	private LocalDate fecha;
	
	@Column(name = "matr_nombre_hilo")
	private Integer nombreHilo;
	
	//estudiante
	@OneToOne(mappedBy = "matricula")
	private Estudiante estudiante;
	
	//materia
	@OneToMany(mappedBy = "matriculaM")
	private List<Materia> materia;

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fecha=" + fecha + ", nombreHilo=" + nombreHilo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha.now();
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha.now();
	}

	public Integer getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(Integer nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public List<Materia> getMateria() {
		return materia;
	}

	public void setMateria(List<Materia> materia) {
		this.materia = materia;
	}
		
}
