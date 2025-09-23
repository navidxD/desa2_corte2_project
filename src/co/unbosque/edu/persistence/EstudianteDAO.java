package co.unbosque.edu.persistence;

import java.util.List;

import co.unbosque.edu.model.Estudiante;

public interface EstudianteDAO {
	
    void guardarEstudiante(Estudiante estudiante);
    Estudiante buscarPorCodigo(String codigo);
    List<Estudiante> obtenerTodos();
    void actualizarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(String codigo);
    void guardarTodos(List<Estudiante> estudiantes);
    
}