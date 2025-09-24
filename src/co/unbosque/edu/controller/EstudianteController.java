package co.unbosque.edu.controller;

import java.util.List;

import co.unbosque.edu.model.auditoria.Auditoria;
import co.unbosque.edu.model.estudiante.RegistroEstudiante;
import co.unbosque.edu.persistence.ConfiguracionDTO;
import co.unbosque.edu.persistence.EstudianteDTO;
import co.unbosque.edu.view.ConsoleView;
import co.unbosque.edu.view.EstudianteView;

public class EstudianteController {
	
	private ConsoleView consoleView;
	private Auditoria auditoria;
	private EstudianteView vista;
	private RegistroEstudiante registroEstudiante;
	
	public EstudianteController(ConsoleView consoleView) {
		this.consoleView = consoleView;
		this.vista = new EstudianteView();
	}
	
	public void init(ConfiguracionDTO configuracionDTO) {
		this.auditoria = new Auditoria(configuracionDTO.getPathReportes());
		registroEstudiante = new RegistroEstudiante(configuracionDTO);
		
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

        if (codigo.isEmpty() || nombre.isEmpty() || carrera.isEmpty() || promedio < 0) {
        	printMessage("Datos inválidos, por favor verifique los campos.");
            return;
        }

        EstudianteDTO dto = new EstudianteDTO(codigo, nombre, carrera, promedio);
        registroEstudiante.guardarEstudiante(dto);

        printMessage("Estudiante registrado: " + nombre);
        vista.limpiarCampos();
        listarEstudiantes();
    }

    private void buscarEstudiante() {
        String codigo = vista.getCodigoBusqueda();
        vista.limpiarTabla();

        EstudianteDTO e = registroEstudiante.buscarPorCodigo(codigo);
        if (e != null) {
            vista.agregarFilaTabla(new Object[]{ e.getCodigo(), e.getNombre(), e.getCarrera(), e.getPromedio() });
            printMessage("Estudiante encontrado: " + e.getNombre());
        } else {
        	printMessage("No se encontró estudiante con código " + codigo);
        }
    }

    private void eliminarEstudiante() {
        String codigo = vista.getCodigoBusqueda();
        EstudianteDTO e = registroEstudiante.buscarPorCodigo(codigo);

        if (e != null) {
            registroEstudiante.eliminarEstudiante(codigo);
            vista.mostrarMensaje("Estudiante eliminado: " + e.getNombre());
            listarEstudiantes();
        } else {
            vista.mostrarMensaje("No se encontró estudiante con código " + codigo);
        }
    }

    private void listarEstudiantes() {
        vista.limpiarTabla();
        List<EstudianteDTO> lista = registroEstudiante.obtenerTodos();
        for (EstudianteDTO e : lista) {
            vista.agregarFilaTabla(new Object[]{ e.getCodigo(), e.getNombre(), e.getCarrera(), e.getPromedio() });
        }
        printMessage("Se listaron todos los estudiantes (" + lista.size() + ")");
    }
    
    private void printMessage(String msg) {
    	auditoria.registrarLog(msg);
    	 vista.mostrarMensaje(msg);
    }
}
