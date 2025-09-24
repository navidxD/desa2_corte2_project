package co.unbosque.edu.persistence;

public class EstudianteDTO {

	private String codigo;
	private String nombre;
	private String carrera;
	private double promedio;
	private boolean isBecado;
	private int porcentajeBeca;

	public EstudianteDTO(String codigo, String nombre, String carrera, double promedio, boolean isBecado, int porcentajeBeca) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.carrera = carrera;
		this.promedio = promedio;
		this.isBecado = isBecado;
		this.porcentajeBeca = porcentajeBeca;
	}

	public String getCodigo() { return codigo; }
	public String getNombre() { return nombre; }
	public String getCarrera() { return carrera; }
	public double getPromedio() { return promedio; }
	public boolean isBecado() { return isBecado; }
	public int getPorcentajeBeca() { return porcentajeBeca; }
}
