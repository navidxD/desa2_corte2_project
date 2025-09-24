package co.unbosque.edu.persistence;

import java.io.FileWriter;
import java.io.IOException;

public class AuditoriaDAO {

	private String path;
	
	public AuditoriaDAO(String path) {
		this.path = path;
	}
	
	
	public void registrarLog(String msg) {
		saveDataToFile(msg);
	}
	
    private void saveDataToFile(String msg) {  
        try (FileWriter writer = new FileWriter(path, true)) { // true para añadir texto
            writer.write(msg);
            writer.write("\n");
            System.out.println("Texto escrito correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
	
	
}
