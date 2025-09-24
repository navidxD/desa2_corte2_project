package co.unbosque.edu.controller;

import java.util.List;

import co.unbosque.edu.exceptions.EstudianteDataInvalidaException;
import co.unbosque.edu.exceptions.EstudianteExistenteException;
import co.unbosque.edu.exceptions.EstudianteNoEncontradoException;
import co.unbosque.edu.exceptions.FalloArchivoException;
import co.unbosque.edu.model.auditoria.Auditoria;
import co.unbosque.edu.model.estudiante.RegistroEstudiante;
import co.unbosque.edu.persistence.EstudianteDTO;
import co.unbosque.edu.view.ConsoleView;
import co.unbosque.edu.view.DialogView;
import co.unbosque.edu.view.EstudianteView;

public class EstudianteController {
	
	private ConsoleView consoleView;
	private DialogView dialogView;
	private Auditoria auditoria;
	private EstudianteView vista;
	private RegistroEstudiante registroEstudiante;
	
	
	public EstudianteController(DialogView dialogView, ConsoleView consoleView) {
		this.consoleView = consoleView;
		this.dialogView = dialogView;
		this.vista = new EstudianteView();
	}
	
	public void init(
			String tituloPantalla,
			String version,
			String pathReportes, String pathEstudiantes, 
			int maxPercentajeBeca, 
			double maxNotaPorEstudiante) {
		
		vista.setTitulo(tituloPantalla + " -- " + version);
		this.auditoria = new Auditoria(pathReportes);
		registroEstudiante = new RegistroEstudiante(pathEstudiantes, 
				maxPercentajeBeca,
				maxNotaPorEstudiante);
		
		listarEstudiantes();
		
		vista.setRegistrarListener(e -> registrarEstudiante());
		vista.setBuscarListener(e -> buscarEstudiante());
		vista.setEliminarListener(e -> eliminarEstudiante());
		vista.setListarListener(e -> listarEstudiantes());
		vista.setLimpiarListener(e -> vista.limpiarCampos());
		
		vista.setVisible(true);
	}

	
    private void registrarEstudiante() {
        String codigo = vista.getCodigo();
        String nombre = vista.getNombre();
        String carrera = vista.getCarrera();
        double promedio = vista.getPromedio();
        int porcentajeBeca = vista.getPorcentajeBeca();
        

        EstudianteDTO dto = new EstudianteDTO(codigo, nombre, carrera, promedio, vista.isBecado(), vista.getPorcentajeBeca());
        try {
			registroEstudiante.guardarEstudiante(dto);
	        printMessage("Estudiante registrado: " + nombre);
	        vista.limpiarCampos();
	        listarEstudiantes();
		} catch (FalloArchivoException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
			dialogView.showDialogMessage("fallo lectura de archivo al guardar estudiante");
			printMessage("fallo lectura de archivo al guardar estudiante");
		} catch (EstudianteExistenteException e) {
			// TODO Auto-generated catch block
			dialogView.showDialogMessage("estudiante ya existe");
			printMessage("estudiante ya existe");
		} catch (EstudianteDataInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dialogView.showDialogMessage("data invalida : " + e.getMessage());
			printMessage(e.getMessage());
		}
    }

    private void buscarEstudiante() {
        String codigo = vista.getCodigoBusqueda();

        EstudianteDTO e;
		try {
			e = registroEstudiante.buscarPorCodigo(codigo);
	        if (e != null) {
	        	dialogView.showInfoEstudiante(e);
	            printMessage("Estudiante encontrado: " + e.getNombre());
	        } else {
	        	printMessage("No se encontró estudiante con código " + codigo);
	        }
		} catch (FalloArchivoException err) {
			err.printStackTrace();
			dialogView.showDialogMessage("fallo lectura de archivo al buscar estudiante");
		} catch (EstudianteNoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			dialogView.showDialogMessage("Estudiante no encontrado");
		}
    }

    private void eliminarEstudiante() {
        String codigo = vista.getCodigoBusqueda();
        EstudianteDTO e;
		try {
			e = registroEstudiante.buscarPorCodigo(codigo);
			
	        if (e != null) {
	            registroEstudiante.eliminarEstudiante(codigo);
	            printMessage("Estudiante eliminado: " + e.getNombre());
	            listarEstudiantes();
	        } else {
	        	printMessage("No se encontró estudiante con código " + codigo);
	        }
		} catch (FalloArchivoException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
			dialogView.showDialogMessage("fallo lectura de archivo al eliminar estudiante");
		} catch (EstudianteNoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			dialogView.showDialogMessage("Estudiante no encontrado");
		}
    }

    private void listarEstudiantes() {
    	
		try {
	        vista.limpiarTabla();
	        List<EstudianteDTO> lista = registroEstudiante.obtenerTodos();
	        for (EstudianteDTO e : lista) {
	        	
	            vista.agregarFilaATablaEstudiante(e);
	        }
	        printMessage("Se listaron todos los estudiantes (" + lista.size() + ")");
		} catch (FalloArchivoException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
			dialogView.showDialogMessage("fallo lectura de archivo al consultar lista estudiante");
		}

    }
    
    private void printMessage(String msg) {
    	auditoria.registrarLog(msg);
    	vista.mostrarMensaje(msg);
    	consoleView.printMessage(msg);
    }
}
