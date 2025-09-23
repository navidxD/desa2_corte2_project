package co.unbosque.edu.controller;

import co.unbosque.edu.model.estudiante.RegistroEstudiante;
import co.unbosque.edu.persistence.ConfiguracionDTO;
import co.unbosque.edu.view.ConsoleView;
import co.unbosque.edu.view.EstudianteView;

public class EstudianteController {
	
	private ConsoleView consoleView;
	private EstudianteView estudianteView;
	private RegistroEstudiante registroEstudiante;
	
	public EstudianteController(ConsoleView consoleView) {
		this.estudianteView = new EstudianteView();
		this.registroEstudiante = new RegistroEstudiante();
	}
	
	
	public void init(ConfiguracionDTO configuracionDTO) {
		estudianteView.setVisible(true);
	}

}
