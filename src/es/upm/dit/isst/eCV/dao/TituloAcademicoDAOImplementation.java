package es.upm.dit.isst.eCV.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.eCV.model.SituacionProfesional;
import es.upm.dit.isst.eCV.model.TituloAcademico;

public class TituloAcademicoDAOImplementation implements TituloAcademicoDAO{

	
	private static TituloAcademicoDAOImplementation instance = null;
	private  TituloAcademicoDAOImplementation() {};
	public static TituloAcademicoDAOImplementation getInstance() {
		if(null == instance) {
			instance = new TituloAcademicoDAOImplementation();
		}
		return instance;
	}
	
	
	
	@Override
	public void create(TituloAcademico tituloAcademico) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(tituloAcademico);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public TituloAcademico read(Integer id) {
		
		TituloAcademico tituloAcademico = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			tituloAcademico = session.get(TituloAcademico.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return tituloAcademico;
	}

	@Override
	public void update(TituloAcademico tituloAcademico) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(tituloAcademico);
			session.getTransaction().commit();
			} catch (Exception e) {
			} finally {
				session.close();
				
				
			}
		
	}

	@Override
	public void delete(TituloAcademico tituloAcademico) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
		session.beginTransaction();
		session.delete(tituloAcademico);
		session.getTransaction().commit();
		} catch (Exception e) {
				} finally {
					session.close();
					
					
				}
		
	}

	@Override
	public List<TituloAcademico> listAll(List<TituloAcademico> titulosAcademicos) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
