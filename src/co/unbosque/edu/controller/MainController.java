package co.unbosque.edu.controller;

import co.unbosque.edu.model.auditoria.Auditoria;
import co.unbosque.edu.view.ConsoleView;

public class MainController {
	
	private ConsoleView consoleView;
	private ConfiguracionController configuracionController;
	private EstudianteController estudianteController;
	
	public MainController() {
		this.consoleView = new ConsoleView();
		this.configuracionController = new ConfiguracionController(consoleView);
		this.estudianteController = new EstudianteController(consoleView);
	}
	
	public void init() {
		configuracionController.init();
		estudianteController.init(configuracionController.obtenerConfig());
	}

}
