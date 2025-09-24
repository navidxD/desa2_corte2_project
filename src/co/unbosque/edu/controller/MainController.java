package co.unbosque.edu.controller;

import co.unbosque.edu.exceptions.FalloArchivoException;
import co.unbosque.edu.persistence.ConfiguracionDTO;
import co.unbosque.edu.view.ConsoleView;
import co.unbosque.edu.view.DialogView;

public class MainController {
	
	private DialogView dialogView;
	private ConsoleView consoleView;
	private ConfiguracionController configuracionController;
	private EstudianteController estudianteController;
	
	public MainController() {
		this.consoleView = new ConsoleView();
		this.dialogView = new DialogView();
		this.configuracionController = new ConfiguracionController(consoleView);
		this.estudianteController = new EstudianteController(dialogView, consoleView);
	}
	
	public void init() {
		try {
			configuracionController.init();
			ConfiguracionDTO configuracionDTO = configuracionController.obtenerConfig();
			estudianteController.init(
					configuracionDTO.getNombreAplicacion(),
					configuracionDTO.getVersion(),
					configuracionDTO.getPathReportes(), 
					configuracionDTO.getPathArchivoEstudiante(),
					configuracionDTO.getMaximoPorcentajeBeca(),
					configuracionDTO.getMaximaNotaPorEstudiante());
		} catch (FalloArchivoException e) {
			dialogView.showDialogMessage("No se pudo iniciar el archivo de configuracion, revise la ruta");
		}
	}

}
