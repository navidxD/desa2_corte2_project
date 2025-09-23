package co.unbosque.edu.persistence;

public class EstudianteDTO {

	private String codigo;
	private String nombre;
	private String carrera;
	private double promedio;

	public EstudianteDTO(String codigo, String nombre, String carrera, double promedio) {
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
