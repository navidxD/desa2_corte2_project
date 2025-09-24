package co.unbosque.edu.model.auditoria;

import co.unbosque.edu.exceptions.FalloArchivoException;
import co.unbosque.edu.persistence.AuditoriaDAO;

public class Auditoria {
	
	private AuditoriaDAO auditoriaDAO;
	
	public Auditoria(String path) {
		this.auditoriaDAO = new AuditoriaDAO(path);
	}
	
	public void registrarLog(String msg) {
		try {
			auditoriaDAO.registrarLog(msg);
		} catch (FalloArchivoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
