package co.unbosque.edu.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguracionDAO {
    private Properties propiedades;
    private String archivoConfig;

    public ConfiguracionDAO(String archivoConfig) {
        this.archivoConfig = archivoConfig;
        this.propiedades = new Properties();
        cargarConfiguracion();
    }

    public void cargarConfiguracion() {
        try (FileInputStream input = new FileInputStream(archivoConfig)) {
            propiedades.load(input);
            System.out.println("Configuración cargada desde: " + archivoConfig);
        } catch (IOException e) {
            System.out.println("Error al cargar configuración: " + e.getMessage());
            establecerConfiguracionPorDefecto();
        }
    }

    public void guardarConfiguracion() {
        try (FileOutputStream output = new FileOutputStream(archivoConfig)) {
            propiedades.store(output, "Configuración del Sistema de Estudiantes");
            System.out.println("Configuración guardada en: " + archivoConfig);
        } catch (IOException e) {
            System.out.println("Error al guardar configuración: " + e.getMessage());
        }
    }

    private void establecerConfiguracionPorDefecto() {
        propiedades.setProperty("nombre.aplicacion", "Sistema Gestión Estudiantes");
        propiedades.setProperty("version", "1.0.0");
        propiedades.setProperty("archivo.datos", "estudiantes.dat");
        propiedades.setProperty("maximo.estudiantes", "100");
        propiedades.setProperty("mostrar.codigos", "true");
        guardarConfiguracion();
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
}