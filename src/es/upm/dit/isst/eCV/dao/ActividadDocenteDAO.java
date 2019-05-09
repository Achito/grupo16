package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.ActividadDocente;

public interface ActividadDocenteDAO {
	
	public void create(ActividadDocente actividadDocente);
	
	public ActividadDocente read (Integer id);
	
	public void update(ActividadDocente actividadDocente);
	
	public void delete (ActividadDocente actividadDocente);
	
	public List<ActividadDocente> listAll(List<ActividadDocente> actividadesDocentes);

}
