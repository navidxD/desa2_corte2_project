package co.unbosque.edu.model.auditoria;

import co.unbosque.edu.persistence.AuditoriaDAO;

public class Auditoria {
	
	private AuditoriaDAO auditoriaDAO;
	
	public Auditoria(String path) {
		this.auditoriaDAO = new AuditoriaDAO(path);
	}
	
	public void registrarLog(String msg) {
		auditoriaDAO.registrarLog(msg);
	}
	
	

}
