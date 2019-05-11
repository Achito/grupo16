package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.PropiedadIntelectual;

public interface PropiedadIntelectualDAO {
	
	public void create(PropiedadIntelectual propiedadIntelectual);
	
	public PropiedadIntelectual read(Integer id);
	
	public void update(PropiedadIntelectual propiedadIntelectual);
	
	public void delete(PropiedadIntelectual propiedadIntelectual);
	
	public List<PropiedadIntelectual> listAll(List<PropiedadIntelectual> propiedadesIntelecuales);

}
