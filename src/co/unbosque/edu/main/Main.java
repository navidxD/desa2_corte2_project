package co.unbosque.edu.main;

import co.unbosque.edu.resources.Configuracion;

public class Main {
    public static void main(String[] args) {

        Configuracion config = new Configuracion();

        config.mostrarConfiguracion();
        
        System.out.println("\n=== PRUEBA DE FUNCIONALIDAD ===");
        
        System.out.println(config.getNombreAplicacion());
        System.out.println(config.getArchivoDatosEstudiantes());
        


        System.out.println(config.getMostrarCodigos());

        config.mostrarConfiguracion();
        
    }
}