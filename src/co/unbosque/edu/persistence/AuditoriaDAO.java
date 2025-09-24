package co.unbosque.edu.persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import co.unbosque.edu.exceptions.FalloArchivoException;

public class AuditoriaDAO {

	private String path;
	
	public AuditoriaDAO(String path) {
		this.path = path;
	}
	
	
	public void registrarLog(String msg) throws FalloArchivoException {
        try (FileWriter writer = new FileWriter(path, true)) { // true para añadir texto
            writer.write((new Date()).toString() + "--" + msg);
            writer.write("\n");
            System.out.println("Texto escrito correctamente en el archivo.");
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            throw new FalloArchivoException();
        }
	}	
	
}
