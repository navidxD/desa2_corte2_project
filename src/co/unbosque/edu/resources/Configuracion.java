package co.unbosque.edu.resources;

public class Configuracion {
    private ConfiguracionDAO configDAO;
    private static final String ARCHIVO_CONFIG = "config.properties";

    public Configuracion() {
        this.configDAO = new ConfiguracionDAO(ARCHIVO_CONFIG);
    }

    public String getNombreAplicacion() {
        return configDAO.getNombreAplicacion();
    }

    public String getVersion() {
        return configDAO.getVersion();
    }

    public String getArchivoDatosEstudiantes() {
        return configDAO.getArchivoDatos();
    }

    public int getMaximoEstudiantes() {
        return configDAO.getMaximoEstudiantes();
    }

    public boolean getMostrarCodigos() {
        return configDAO.getMostrarCodigos();
    }

    public void cambiarMostrarCodigos(boolean mostrar) {
        configDAO.setMostrarCodigos(mostrar);
        configDAO.guardarConfiguracion();
    }

    public void cambiarArchivoDatos(String nuevoArchivo) {
        configDAO.setArchivoDatos(nuevoArchivo);
        configDAO.guardarConfiguracion();
    }

    public void mostrarConfiguracion() {
        System.out.println("=== CONFIGURACIÓN ACTUAL ===");
        System.out.println("Aplicación: " + getNombreAplicacion());
        System.out.println("Versión: " + getVersion());
        System.out.println("Archivo de datos: " + getArchivoDatosEstudiantes());
        System.out.println("Máximo estudiantes: " + getMaximoEstudiantes());
        System.out.println("Mostrar códigos: " + getMostrarCodigos());
    }
}