package es.upm.dit.isst.eCV.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.eCV.model.ActividadDocente;

public class ActividadDocenteDAOImplementation implements ActividadDocenteDAO {

	private static ActividadDocenteDAOImplementation instance = null;
	private  ActividadDocenteDAOImplementation() {};
	public static ActividadDocenteDAOImplementation getInstance() {
		if(null == instance) {
			instance = new ActividadDocenteDAOImplementation();
		}
		return instance;
	}
	
	
	
	@Override
	public void create(ActividadDocente actividadDocente) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(actividadDocente);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public ActividadDocente read(Integer id) {
		
		ActividadDocente actividadDocente = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			actividadDocente = session.get(ActividadDocente.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return actividadDocente;
	}

	@Override
	public void update(ActividadDocente actividadDocente) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(actividadDocente);
			session.getTransaction().commit();
			} catch (Exception e) {
			} finally {
				session.close();
				
				
			}
		
	}

	@Override
	public void delete(ActividadDocente actividadDocente) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
		session.beginTransaction();
		session.delete(actividadDocente);
		session.getTransaction().commit();
		} catch (Exception e) {
				} finally {
					session.close();
					
					
				}
		
	}

	@Override
	public List<ActividadDocente> listAll(List<ActividadDocente> actividadDocentes) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
