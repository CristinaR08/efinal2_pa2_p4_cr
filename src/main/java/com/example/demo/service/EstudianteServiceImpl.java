package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Estudiante estudiante) {
		this.estudianteRepo.insertar(estudiante);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepo.actualizar(estudiante);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante buscarId(Integer id) {
		return this.estudianteRepo.buscar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Estudiante> listaEstudiantes() {
		return this.estudianteRepo.buscarTodos();
	}

}
/*
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Agregar Producto</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
		integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
	<form th:action="@{/productos/guardar}" th:object="${producto}" th:method="POST">	
		<table>
			<tr>
				<td><label>Nombre:</label></td>
				<td><input type="text" th:field="${producto.nombre}"></td>
			</tr>
			<tr>
				<td><label>Código de Barras Maestro:</label></td>
				<td><input type="text" th:field="${producto.codigoBarrasM}"></td>
			</tr>
			<tr>
				<td><label>Categoría:</label></td>
				<td><input type="text" th:field="${producto.categoria}"></td>
			</tr>
		</table>
		<input type="submit" value="Agregar Producto"> 
	</form>
</body>

</html>
*/