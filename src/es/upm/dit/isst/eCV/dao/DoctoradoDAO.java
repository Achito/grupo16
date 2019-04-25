package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.Doctorado;

public interface DoctoradoDAO {
	
	public void create(Doctorado doctorado);
	
	public Doctorado read (Integer id);
	
	public void update(Doctorado doctorado);
	
	public void delete (Doctorado doctorado);
	
	public List<Doctorado> listAll(List<Doctorado> doctorados);

}
