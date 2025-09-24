package co.unbosque.edu.model.estudiante;

import java.io.Serializable;

public class Estudiante implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String carrera;
	private double promedio;

	public Estudiante(String codigo, String nombre, String carrera, double promedio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.carrera = carrera;
		this.promedio = promedio;
	}

	public String getCodigo() { return codigo; }
	public String getNombre() { return nombre; }
	public String getCarrera() { return carrera; }
	public double getPromedio() { return promedio; }


}
