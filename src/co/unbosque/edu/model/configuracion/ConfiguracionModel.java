package co.unbosque.edu.model.configuracion;

import co.unbosque.edu.exceptions.FalloArchivoException;
import co.unbosque.edu.persistence.ConfiguracionDAO;
import co.unbosque.edu.persistence.ConfiguracionDTO;

public class ConfiguracionModel {
	
    private ConfiguracionDAO configDAO;
	
	public ConfiguracionModel() {
		this.configDAO = new ConfiguracionDAO();
	}
	
	public void init() throws FalloArchivoException {
		configDAO.cargarConfiguracion();
	}
	
	public ConfiguracionDTO obtenerConfigActual() {
		ConfiguracionDTO configuracionDTO = new ConfiguracionDTO();
		
		configuracionDTO.setMaximoPorcentajeBeca(configDAO.getMaximoPorcentajeBeca());
		configuracionDTO.setMostrarCodigos(configDAO.getMostrarCodigos());
		configuracionDTO.setNombreAplicacion(configDAO.getNombreAplicacion());
		configuracionDTO.setPathArchivoEstudiante(configDAO.getArchivoDatos());
		configuracionDTO.setVersion(configDAO.getVersion());
		configuracionDTO.setPathReportes(configDAO.getArchivoReportes());
		configuracionDTO.setMaximaNotaPorEstudiante(configDAO.getMaximaNotaPorEstudiante());
		configuracionDTO.setMinNotaParaAprobar(configDAO.getMinNotaAprobada());
		
		return configuracionDTO;
	}

}