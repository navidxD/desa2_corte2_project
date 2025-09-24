package co.unbosque.edu.view;

import javax.swing.JOptionPane;

import co.unbosque.edu.persistence.EstudianteDTO;

public class DialogView {
	
	public void showDialogMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void showInfoEstudiante(EstudianteDTO e) {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("Data Estudiante:");
    	stringBuilder.append("\n");
    	stringBuilder.append("Codigo:" + e.getCodigo());
    	stringBuilder.append("\n");
    	stringBuilder.append("Nombre:" + e.getNombre());
    	stringBuilder.append("\n");
    	stringBuilder.append("Carrera:" + e.getCarrera());
    	stringBuilder.append("\n");
    	stringBuilder.append("Promedio:" + e.getPromedio());
    	stringBuilder.append("\n");
    	
    	showDialogMessage(stringBuilder.toString());
	}
	
}
