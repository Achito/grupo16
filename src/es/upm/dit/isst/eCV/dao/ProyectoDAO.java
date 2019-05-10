package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.Proyecto;

public interface ProyectoDAO {
	
public void create(Proyecto proyecto);
	
	public Proyecto read(Integer id);
	
	public void update(Proyecto proyecto);
	
	public void delete(Proyecto proyecto);
	
	public List<Proyecto> listAll(List<Proyecto> proyectos);

}



