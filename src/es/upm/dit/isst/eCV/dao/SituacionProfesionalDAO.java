package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.SituacionProfesional;

public interface SituacionProfesionalDAO {
	
	public void create(SituacionProfesional situacionProfesional);
	
	public SituacionProfesional read(Integer id);
	
	public void update(SituacionProfesional situacionProfesional);
	
	public void delete(SituacionProfesional situacionProfesional);
	
	public List<SituacionProfesional> listAll(List<SituacionProfesional> situacionesProfesionales);

}
