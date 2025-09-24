package co.unbosque.edu.model.estudiante;

import java.util.ArrayList;
import java.util.List;

import co.unbosque.edu.persistence.ConfiguracionDTO;
import co.unbosque.edu.persistence.EstudianteDAO;
import co.unbosque.edu.persistence.EstudianteDTO;

public class RegistroEstudiante {

	private EstudianteDAO estudianteDAO;
	
	public RegistroEstudiante(ConfiguracionDTO configuracionDTO) {
		estudianteDAO = new EstudianteDAO(configuracionDTO.getPathArchivoEstudiante());
	}
	
    public void guardarEstudiante(EstudianteDTO dto) {
    	estudianteDAO.guardarEstudiante(dtoAModelo(dto));
    };
    
    public EstudianteDTO buscarPorCodigo(String codigo) {
    	return modeloADto(estudianteDAO.buscarPorCodigo(codigo));
    };
    
    public List<EstudianteDTO> obtenerTodos() {
    	return modeloADtoList(estudianteDAO.obtenerTodos());
    };
    
    public void actualizarEstudiante(EstudianteDTO estudiante) {
    	estudianteDAO.actualizarEstudiante(dtoAModelo(estudiante));
    };
    
    public void eliminarEstudiante(String codigo) {
    	estudianteDAO.eliminarEstudiante(codigo);
    };
    
    public void guardarTodos(List<EstudianteDTO> estudiantes) {
    	estudianteDAO.guardarTodos(dtoAModeloList(estudiantes));
    };
    
    private Estudiante dtoAModelo(EstudianteDTO dto) {
    	 return new Estudiante(dto.getCodigo(), 
     			dto.getNombre(), 
     			dto.getCarrera(), 
     			dto.getPromedio()
     			);
    }
    
    private List<Estudiante> dtoAModeloList(List<EstudianteDTO> dtos) {
    	List<Estudiante> res = new ArrayList<Estudiante>();
    	 
    	for (EstudianteDTO e : dtos) {
    		res.add(dtoAModelo(e));
    	}
    	
    	return res;
    }
    
    private EstudianteDTO modeloADto(Estudiante model) {
   	 return new EstudianteDTO(model.getCodigo(), 
   			    model.getNombre(), 
   			    model.getCarrera(), 
    			model.getPromedio()
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
