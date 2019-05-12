package es.upm.dit.isst.eCV.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.eCV.model.ActividadSanitaria;

public class ActividadSanitariaDAOImplementation implements ActividadSanitariaDAO {

	private static ActividadSanitariaDAOImplementation instance = null;
	private  ActividadSanitariaDAOImplementation() {};
	public static ActividadSanitariaDAOImplementation getInstance() {
		if(null == instance) {
			instance = new ActividadSanitariaDAOImplementation();
		}
		return instance;
	}
	
	
	
	@Override
	public void create(ActividadSanitaria actividadSanitaria) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(actividadSanitaria);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public ActividadSanitaria read(Integer id) {
		
		ActividadSanitaria actividadSanitaria = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			actividadSanitaria = session.get(ActividadSanitaria.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return actividadSanitaria;
	}

	@Override
	public void update(ActividadSanitaria actividadSanitaria) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(actividadSanitaria);
			session.getTransaction().commit();
			} catch (Exception e) {
			} finally {
				session.close();
				
				
			}
		
	}

	@Override
	public void delete(ActividadSanitaria actividadSanitaria) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
		session.beginTransaction();
		session.delete(actividadSanitaria);
		session.getTransaction().commit();
		} catch (Exception e) {
				} finally {
					session.close();
					
					
				}
		
	}

	@Override
	public List<ActividadSanitaria> listAll(List<ActividadSanitaria> actividadSanitarias) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
