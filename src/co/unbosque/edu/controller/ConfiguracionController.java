package co.unbosque.edu.controller;

import co.unbosque.edu.exceptions.FalloArchivoException;
import co.unbosque.edu.model.configuracion.ConfiguracionModel;
import co.unbosque.edu.persistence.ConfiguracionDTO;
import co.unbosque.edu.view.ConsoleView;

public class ConfiguracionController {
	
	private ConsoleView consoleView;
	private ConfiguracionModel configuracionModel;
	
	public ConfiguracionController(ConsoleView consoleView) {
		this.consoleView = consoleView;
		this.configuracionModel = new ConfiguracionModel();
	}
	
	public void init() throws FalloArchivoException {
		configuracionModel.init();
	}
	
	public ConfiguracionDTO obtenerConfig() {
        ConfiguracionDTO config = configuracionModel.obtenerConfigActual();
        
        consoleView.printMessage("\n=== PRUEBA DE CONFIGURACION ===");
        consoleView.printMessage(config.getNombreAplicacion());
        consoleView.printMessage(config.getPathArchivoEstudiante());
        consoleView.printMessage(config.isMostrarCodigos());
        consoleView.printMessage(config.getPathReportes());
        
        return config;
	}

}
