package co.unbosque.edu.model.configuracion;

import co.unbosque.edu.persistence.ConfiguracionDAO;
import co.unbosque.edu.persistence.ConfiguracionDTO;

public class ConfiguracionModel {
	
    private ConfiguracionDAO configDAO;
	
	public ConfiguracionModel() {
		this.configDAO = new ConfiguracionDAO();
	}
	
	public void init() {
		configDAO.cargarConfiguracion();
	}
	
	public ConfiguracionDTO obtenerConfigActual() {
		ConfiguracionDTO configuracionDTO = new ConfiguracionDTO();
		
		configuracionDTO.setMaximoEstudiantes(configDAO.getMaximoEstudiantes());
		configuracionDTO.setMostrarCodigos(configDAO.getMostrarCodigos());
		configuracionDTO.setNombreAplicacion(configDAO.getNombreAplicacion());
		configuracionDTO.setPathArchivoEstudiante(configDAO.getArchivoDatos());
		configuracionDTO.setVersion(configDAO.getVersion());
		configuracionDTO.setPathReportes(configDAO.getArchivoReportes());
		
		return configuracionDTO;
	}

}