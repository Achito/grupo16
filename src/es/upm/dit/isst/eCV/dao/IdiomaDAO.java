package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.Idioma;

public interface IdiomaDAO {
	
public void create(Idioma idioma);
	
	public Idioma read(Integer id);
	
	public void update(Idioma idioma);
	
	public void delete(Idioma idioma);
	
	public List<Idioma> listAll(List<Idioma> idiomas);

}
