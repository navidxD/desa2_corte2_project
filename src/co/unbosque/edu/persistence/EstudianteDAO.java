package co.unbosque.edu.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import co.unbosque.edu.model.estudiante.Estudiante;

public class EstudianteDAO {
	
	private String path;
	private List<Estudiante> lista;
	
	public EstudianteDAO(String path) {
		this.path = path;
		this.lista = new ArrayList<Estudiante>();
	}
	
    public void guardarEstudiante(Estudiante estudiante) {
    	getDataFromFile();
    	lista.add(estudiante);
    	saveDataToFile();
    };
    
    public Estudiante buscarPorCodigo(String codigo) {
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
    
    public List<Estudiante> obtenerTodos() {
    	getDataFromFile();
    	
    	return lista;
    };
    
    public void actualizarEstudiante(Estudiante estudiante) {
    	getDataFromFile();
    	Estudiante e = buscarPorCodigo(estudiante.getCodigo());
    	
    	if (e != null) {
    		lista.set(lista.indexOf(e), e);
    	}
    	
    	saveDataToFile();
    };
    
    public void eliminarEstudiante(String codigo) {
    	getDataFromFile();
    	Estudiante e = buscarPorCodigo(codigo);
    	
    	if (e != null) {
    		lista.remove(e);
    	}
    	
    	saveDataToFile();
    };
    
    public void guardarTodos(List<Estudiante> estudiantes) {
    	this.lista = estudiantes;
    	saveDataToFile();
    };
    
    
	private void getDataFromFile() {  
    	try (FileInputStream fileIn = new FileInputStream(path); 
    		 ObjectInputStream in = new ObjectInputStream(fileIn)) {

               // 1. Leer el objeto del archivo
               lista = (List<Estudiante>) in.readObject();

           } catch (IOException i) {
               System.out.println("Error de E/S: " + i.getMessage());
           } catch (ClassNotFoundException c) {
               System.out.println("La clase Usuario no fue encontrada.");
               c.printStackTrace();
           }
    }
    
    private void saveDataToFile() {  
    	
    	try (FileOutputStream fileIn = new FileOutputStream(path); 
    			ObjectOutputStream in = new ObjectOutputStream(fileIn)) {

               // 1. Leer el objeto del archivo
               in.writeObject(lista);

           } catch (IOException i) {
               System.out.println("Error de E/S: " + i.getMessage());
           }
    }
}