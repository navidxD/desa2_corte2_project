package co.unbosque.edu.model.estudiante;

public class EstudianteBecado extends Estudiante {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int porcentajeBeca;

	public EstudianteBecado(String codigo, String nombre, String carrera, double promedio, int porcentajeBeca) {
		super(codigo, nombre, carrera, promedio);
		
		this.porcentajeBeca = porcentajeBeca;
	}
	
	
	public void setPorcentajeBeca(int porcentajeBeca) {
		this.porcentajeBeca = porcentajeBeca;
	}
	
	public int getPorcentajeBeca() {
		return porcentajeBeca;
	}
	

}
