package co.unbosque.edu.model.estudiante;

import java.util.ArrayList;
import java.util.List;

import co.unbosque.edu.exceptions.EstudianteExistenteException;
import co.unbosque.edu.exceptions.EstudianteNoEncontradoException;
import co.unbosque.edu.exceptions.FalloArchivoException;
import co.unbosque.edu.exceptions.EstudianteDataInvalidaException;
import co.unbosque.edu.persistence.EstudianteDAO;
import co.unbosque.edu.persistence.EstudianteDTO;

public class RegistroEstudiante {

	private EstudianteDAO estudianteDAO;
	private int maxPercentajeBeca;
	private double maxNotaPorEstudiante;
	
	public RegistroEstudiante(String pathStudents, int maxPercentajeBeca, double maxNotaPorEstudiante) {
		this.estudianteDAO = new EstudianteDAO(pathStudents);
		this.maxNotaPorEstudiante = maxNotaPorEstudiante;
		this.maxPercentajeBeca = maxPercentajeBeca;
	}
	
    public void guardarEstudiante(EstudianteDTO dto) throws FalloArchivoException, EstudianteExistenteException, EstudianteDataInvalidaException {
    	Estudiante encontrado = estudianteDAO.buscarPorCodigo(dto.getCodigo());
    	
    	if (encontrado != null) {
    		throw new EstudianteExistenteException();
    	}
    	
    	if (dto.getCodigo().isEmpty() || dto.getNombre().isEmpty() || dto.getCarrera().isEmpty() || dto.getPromedio() < 0) {
        	throw new EstudianteDataInvalidaException("Datos inválidos, por favor verifique los campos.");
        }
    	
    	if (dto.getPromedio() > maxNotaPorEstudiante) {
    		throw new EstudianteDataInvalidaException("nota invalida supera el maximo de: " + maxNotaPorEstudiante);
    	}
    	
    	if (dto.getPorcentajeBeca() > maxPercentajeBeca) {
    		throw new EstudianteDataInvalidaException("pocentaje de beca invalido invalida supera el maximo de: " + maxPercentajeBeca);
    	}
    	
    	estudianteDAO.guardarEstudiante(dtoAModelo(dto));
    };
    
    public EstudianteDTO buscarPorCodigo(String codigo) throws FalloArchivoException, EstudianteNoEncontradoException {
    	Estudiante encontrado = estudianteDAO.buscarPorCodigo(codigo);
    	if (encontrado == null) {
    		throw new EstudianteNoEncontradoException(codigo);
    	}
    	
    	return modeloADto(estudianteDAO.buscarPorCodigo(codigo));
    };
    
    public List<EstudianteDTO> obtenerTodos() throws FalloArchivoException {
    	return modeloADtoList(estudianteDAO.obtenerTodos());
    };
    
    public void actualizarEstudiante(EstudianteDTO estudiante) throws FalloArchivoException {
    	estudianteDAO.actualizarEstudiante(dtoAModelo(estudiante));
    };
    
    public void eliminarEstudiante(String codigo) throws FalloArchivoException {
    	estudianteDAO.eliminarEstudiante(codigo);
    };
    
    public void guardarTodos(List<EstudianteDTO> estudiantes) throws FalloArchivoException {
    	estudianteDAO.guardarTodos(dtoAModeloList(estudiantes));
    };
    
    private Estudiante dtoAModelo(EstudianteDTO dto) {
    	if (dto.isBecado()) {
       	 return new EstudianteBecado(
       			 dto.getCodigo(), 
      			dto.getNombre(), 
      			dto.getCarrera(), 
      			dto.getPromedio(),
      			dto.getPorcentajeBeca()
      			);
    	} else {
       	 return new Estudiante(dto.getCodigo(), 
      			dto.getNombre(), 
      			dto.getCarrera(), 
      			dto.getPromedio()
      			);	
    	}
    }
    
    private List<Estudiante> dtoAModeloList(List<EstudianteDTO> dtos) {
    	List<Estudiante> res = new ArrayList<Estudiante>();
    	 
    	for (EstudianteDTO e : dtos) {
    		res.add(dtoAModelo(e));
    	}
    	
    	return res;
    }
    
    private EstudianteDTO modeloADto(Estudiante model) {
     boolean isBecado = false;
     int porcentajeBeca = 0;
     if (model instanceof EstudianteBecado) {
    	 isBecado = true;
    	 porcentajeBeca = (((EstudianteBecado) model).getPorcentajeBeca());
    	 
     }
   	 return new EstudianteDTO(model.getCodigo(), 
   			    model.getNombre(), 
   			    model.getCarrera(), 
    			model.getPromedio(),
    			isBecado,
    			porcentajeBeca
    			);
   }
   
   private List<EstudianteDTO> modeloADtoList(List<Estudiante> dtos) {
   	List<EstudianteDTO> res = new ArrayList<EstudianteDTO>();
   	 
   	for (Estudiante e : dtos) {
   		res.add(modeloADto(e));
   	}
   	
   	return res;
   }
    
	
}
