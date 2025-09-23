package co.unbosque.edu.controller;

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
	
	public void init() {
		configuracionModel.init();
	}
	
	public ConfiguracionDTO obtenerConfig() {
		configuracionModel.init();
		
        ConfiguracionDTO config = configuracionModel.obtenerConfigActual();
        
        consoleView.printMessage("\n=== SUPER PRUEBA DE FUNCIONALIDAD ===");
        
        consoleView.printMessage(config.getNombreAplicacion());
        consoleView.printMessage(config.getPathArchivoEstudiante());
        consoleView.printMessage(config.isMostrarCodigos());
        consoleView.printMessage(config.getPathReportes());
        
        return config;
	}

}
