package co.unbosque.edu.persistence;

public class ConfiguracionDTO {
	
	private String nombreAplicacion;
	private String version;
	private String pathArchivoEstudiante;
	private String pathReportes;
	private int maximoPorcentajeBeca;
	private int maximaNotaPorEstudiante;
	private double minNotaParaAprobar;
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

	public int getMaximoPorcentajeBeca() {
		return maximoPorcentajeBeca;
	}

	public void setMaximoPorcentajeBeca(int maximoPorcentajeBeca) {
		this.maximoPorcentajeBeca = maximoPorcentajeBeca;
	}

	public boolean isMostrarCodigos() {
		return mostrarCodigos;
	}

	public void setMostrarCodigos(boolean mostrarCodigos) {
		this.mostrarCodigos = mostrarCodigos;
	}

	public int getMaximaNotaPorEstudiante() {
		return maximaNotaPorEstudiante;
	}

	public void setMaximaNotaPorEstudiante(int maximaNotaPorEstudiante) {
		this.maximaNotaPorEstudiante = maximaNotaPorEstudiante;
	}
	
	public double getMinNotaParaAprobar() {
		return minNotaParaAprobar;
	}
	
	public void setMinNotaParaAprobar(double minNotaParaAprobar) {
		this.minNotaParaAprobar = minNotaParaAprobar;
	}

}
