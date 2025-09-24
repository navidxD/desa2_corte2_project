package co.unbosque.edu.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import co.unbosque.edu.exceptions.FalloArchivoException;
import co.unbosque.edu.model.estudiante.Estudiante;

public class EstudianteDAO {
	
	private String path;
	private List<Estudiante> lista;
	
	public EstudianteDAO(String path) {
		this.path = path;
		this.lista = new ArrayList<Estudiante>();
	}
	
    public void guardarEstudiante(Estudiante estudiante) throws FalloArchivoException {
    	getDataFromFile();
    	lista.add(estudiante);
    	saveDataToFile();
    };
    
    public Estudiante buscarPorCodigo(String codigo) throws FalloArchivoException {
    	Estudiante estudiante = null;
    	getDataFromFile();
    	
    	for (Estudiante e : lista) {
    		if (e.getCodigo().equals(codigo)) {
    			estudiante = e;
    			break;
    		}
    	}
    	
    	return estudiante;
    };
    
    public List<Estudiante> obtenerTodos() throws FalloArchivoException {
    	getDataFromFile();
    	
    	return lista;
    };
    
    public void actualizarEstudiante(Estudiante estudiante) throws FalloArchivoException {
    	getDataFromFile();
    	Estudiante e = buscarPorCodigo(estudiante.getCodigo());
    	
    	if (e != null) {
    		lista.set(lista.indexOf(e), e);
    	}
    	
    	saveDataToFile();
    };
    
    public void eliminarEstudiante(String codigo) throws FalloArchivoException {
    	getDataFromFile();
    	Estudiante e = buscarPorCodigo(codigo);
    	
    	if (e != null) {
    		lista.remove(e);
    	}
    	
    	saveDataToFile();
    };
    
    public void guardarTodos(List<Estudiante> estudiantes) throws FalloArchivoException {
    	this.lista = estudiantes;
    	saveDataToFile();
    };
    
    
	private void getDataFromFile() throws FalloArchivoException {  
    	try (FileInputStream fileIn = new FileInputStream(path); 
    		 ObjectInputStream in = new ObjectInputStream(fileIn)) {

               // 1. Leer el objeto del archivo
               lista = (List<Estudiante>) in.readObject();

           } catch (Exception e) {
               System.out.println("Error de E/S: " + e.getMessage());
               throw new FalloArchivoException();
           }
    }
    
    private void saveDataToFile() throws FalloArchivoException {  
    	
    	try (FileOutputStream fileIn = new FileOutputStream(path); 
    			ObjectOutputStream in = new ObjectOutputStream(fileIn)) {

               // 1. Leer el objeto del archivo
               in.writeObject(lista);

           } catch (IOException i) {
               System.out.println("Error de E/S: " + i.getMessage());
               throw new FalloArchivoException();
           }
    }
}