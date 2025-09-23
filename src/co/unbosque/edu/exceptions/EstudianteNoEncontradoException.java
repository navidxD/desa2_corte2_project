package co.unbosque.edu.exceptions;

@SuppressWarnings("serial")
public class EstudianteNoEncontradoException extends Exception {
    
    public EstudianteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
    
    public EstudianteNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
    
    public EstudianteNoEncontradoException(String codigoEstudiante, String operacion) {
        super("Estudiante con código '" + codigoEstudiante + "' no encontrado durante: " + operacion);
    }
    

}