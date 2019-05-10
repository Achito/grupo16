package es.upm.dit.isst.eCV.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.eCV.model.Proyecto;

public class ProyectoDAOImplementation implements ProyectoDAO {

	private static ProyectoDAOImplementation instance = null;
	private  ProyectoDAOImplementation() {};
	public static ProyectoDAOImplementation getInstance() {
		if(null == instance) {
			instance = new ProyectoDAOImplementation();
		}
		return instance;
	}
	
	
	
	@Override
	public void create(Proyecto proyecto) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(proyecto);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Proyecto read(Integer id) {
		
		Proyecto proyecto = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			proyecto = session.get(Proyecto.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return proyecto;
	}

	@Override
	public void update(Proyecto proyecto) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(proyecto);
			session.getTransaction().commit();
			} catch (Exception e) {
			} finally {
				session.close();
				
				
			}
		
	}

	@Override
	public void delete(Proyecto proyecto) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
		session.beginTransaction();
		session.delete(proyecto);
		session.getTransaction().commit();
		} catch (Exception e) {
				} finally {
					session.close();
					
					
				}
		
	}

	@Override
	public List<Proyecto> listAll(List<Proyecto> proyectos) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
