package co.unbosque.edu.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.module.Configuration;
import java.util.Properties;

import co.unbosque.edu.model.configuracion.ConfiguracionModel;

public class ConfiguracionDAO {
	
    private static final String ARCHIVO_CONFIG = "..\\assets\\config.properties";
    private Properties propiedades;

    public ConfiguracionDAO() {
        this.propiedades = new Properties();
    }

    public void cargarConfiguracion() {
    	try (FileInputStream input = new FileInputStream(new File(getPath()))) {
            propiedades.load(input);
            System.out.println("Configuración cargada desde: " + ARCHIVO_CONFIG);
        } catch (IOException e) {
            System.out.println("Error al cargar configuración: " + e.getMessage());
        }
    }

    public void guardarConfiguracion(ConfiguracionModel configuration) {
        try (FileOutputStream output = new FileOutputStream(new File(getPath()))) {
            propiedades.store(output, "Configuración del Sistema de Estudiantes");
            System.out.println("Configuración guardada en: " + ARCHIVO_CONFIG);
        } catch (IOException e) {
            System.out.println("Error al guardar configuración: " + e.getMessage());
        }
    }


    public String getNombreAplicacion() {
        return propiedades.getProperty("nombre.aplicacion");
    }

    public String getVersion() {
        return propiedades.getProperty("version");
    }

    public String getArchivoDatos() {
        return propiedades.getProperty("archivo.datos");
    }
    
    public String getArchivoReportes() {
        return propiedades.getProperty("archivo.reportes");
    }
    
    public int getMaximoEstudiantes() {
        return Integer.parseInt(propiedades.getProperty("maximo.estudiantes"));
    }

    public boolean getMostrarCodigos() {
        return Boolean.parseBoolean(propiedades.getProperty("mostrar.codigos"));
    }

    public void setMostrarCodigos(boolean mostrar) {
        propiedades.setProperty("mostrar.codigos", String.valueOf(mostrar));
    }

    public void setArchivoDatos(String archivo) {
        propiedades.setProperty("archivo.datos", archivo);
    }
    
    private String getPath() {
    	String directorioActual = System.getProperty("user.dir");
    	System.out.println("Directorio de trabajo actual: " + directorioActual);
    	
    	directorioActual = directorioActual + "\\src\\assets\\config.properties";
    	
    	return directorioActual;
    }
}