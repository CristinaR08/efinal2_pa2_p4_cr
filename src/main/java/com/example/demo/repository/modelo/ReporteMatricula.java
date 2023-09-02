package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "reporte")
public class ReporteMatricula {
	
	@Id
	@SequenceGenerator(name = "seq_reporte",sequenceName = "seq_reporte",allocationSize = 1)
	@GeneratedValue(generator = "seq_reporte",strategy = GenerationType.SEQUENCE)
	@Column(name = "repo_id")
	private Integer id;
	
	@Column(name = "repo_cedula")
	private String cedula;
	
	@Column(name = "repo_codigo")
	private String codigo;
	
	@Column(name = "repo_fecha")
	private String fecha;
	
	@Column(name = "repo_hila")
	private String hilo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHilo() {
		return hilo;
	}

	public void setHilo(String hilo) {
		this.hilo = hilo;
	}
	 
}
