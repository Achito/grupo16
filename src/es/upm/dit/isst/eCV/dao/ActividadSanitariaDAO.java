package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.ActividadSanitaria;

public interface ActividadSanitariaDAO {
	
	public void create(ActividadSanitaria actividadSanitaria);
	
	public ActividadSanitaria read (Integer id);
	
	public void update(ActividadSanitaria actividadSanitaria);
	
	public void delete (ActividadSanitaria actividadSanitaria);
	
	public List<ActividadSanitaria> listAll(List<ActividadSanitaria> actividadSanitarias);

}
