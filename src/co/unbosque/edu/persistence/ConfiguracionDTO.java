package co.unbosque.edu.persistence;

public class ConfiguracionDTO {
	
	private String nombreAplicacion;
	private String version;
	private String pathArchivoEstudiante;
	private String pathReportes;
	private int maximoEstudiantes;
	private boolean mostrarCodigos;

    public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPathArchivoEstudiante() {
		return pathArchivoEstudiante;
	}

	public void setPathArchivoEstudiante(String pathArchivoEstudiante) {
		this.pathArchivoEstudiante = pathArchivoEstudiante;
	}

	public String getPathReportes() {
		return pathReportes;
	}

	public void setPathReportes(String pathReportes) {
		this.pathReportes = pathReportes;
	}

	public int getMaximoEstudiantes() {
		return maximoEstudiantes;
	}


	public void setMaximoEstudiantes(int maximoEstudiantes) {
		this.maximoEstudiantes = maximoEstudiantes;
	}

	public boolean isMostrarCodigos() {
		return mostrarCodigos;
	}

	public void setMostrarCodigos(boolean mostrarCodigos) {
		this.mostrarCodigos = mostrarCodigos;
	}

}
