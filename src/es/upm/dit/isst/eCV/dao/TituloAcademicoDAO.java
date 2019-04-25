package es.upm.dit.isst.eCV.dao;

import java.util.List;

import es.upm.dit.isst.eCV.model.TituloAcademico;

public interface TituloAcademicoDAO {
	
	public void create(TituloAcademico tituloAcademico);
	
	public TituloAcademico read (Integer id);
	
	public void update(TituloAcademico tituloAcademico);
	
	public void delete (TituloAcademico tituloAcademico);
	
	public List<TituloAcademico> listAll(List<TituloAcademico> titulosAcademicos);
	
	

}
