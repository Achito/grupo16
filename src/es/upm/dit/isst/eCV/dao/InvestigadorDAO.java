package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.Investigador;;

public interface InvestigadorDAO {

	public void create(Investigador investigador);
	
	public Investigador read(Integer id);
	
	
	
	public void update(Investigador investigador);
	
	public void delete(Investigador investigador);
	
	public List<Investigador> readAll();
	
	
	public Investigador readByEmail(String email);

	
	
}
