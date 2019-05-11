package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.Publicacion;

public interface PublicacionDAO {
	
public void create(Publicacion publicacion);
	
	public Publicacion read(Integer id);
	
	public void update(Publicacion publicacion);
	
	public void delete(Publicacion publicacion);
	
	public List<Publicacion> listAll(List<Publicacion> publicaciones);

}



