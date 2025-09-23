package co.unbosque.edu.model;

import co.unbosque.edu.persistence.EstudianteDTO;

public class Estudiante {
	private EstudianteDTO datos;

	public Estudiante(EstudianteDTO datos) {
		this.datos = datos;
	}

	public String getCodigo() { return	datos.getCodigo(); }
	public String getNombre() { return	datos.getNombre(); }
	public String getCarrera() { return datos.getCarrera(); }
	public double getPromedio() { return datos.getPromedio(); }

}
