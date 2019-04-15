package es.upm.dit.isst.eCV.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.model.SituacionProfesional;

public class SituacionProfesionalDAOImplementation implements SituacionProfesionalDAO{

	
	private static SituacionProfesionalDAOImplementation instance = null;
	private SituacionProfesionalDAOImplementation() {};
	public static SituacionProfesionalDAOImplementation getInstance() {
		
		if(null == instance) {
			instance = new SituacionProfesionalDAOImplementation();
		}
		
		return instance;
	}
	
	
	@Override
	public void create(SituacionProfesional situacionProfesional) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(situacionProfesional);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
		
	}

	
	@Override
	public SituacionProfesional read(Integer id) {
		
		SituacionProfesional situacionProfesional = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			situacionProfesional = session.get(SituacionProfesional.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return situacionProfesional;
	}
	

	@Override
	public void update(SituacionProfesional situacionProfesional) {
		
			Session  session = SessionFactoryService.get().openSession();
		
				try {
			session.beginTransaction();
			session.saveOrUpdate(situacionProfesional);
			session.getTransaction().commit();
					} catch (Exception e) {
					} finally {
						session.close();
						
						
					}
		
	}

	@Override
	public void delete(SituacionProfesional situacionProfesional) {
		
		Session  session = SessionFactoryService.get().openSession();
		
			try {
			session.beginTransaction();
			session.delete(situacionProfesional);
			session.getTransaction().commit();
			} catch (Exception e) {
					} finally {
						session.close();
						
						
					}
		
	}

	@Override
	public List<SituacionProfesional> listAll(List<SituacionProfesional> situacionesProfesionales) {
		// TODO Auto-generated method stub
		return null;
	}

}
