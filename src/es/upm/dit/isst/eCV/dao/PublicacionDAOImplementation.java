package es.upm.dit.isst.eCV.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.eCV.model.Publicacion;

public class PublicacionDAOImplementation implements PublicacionDAO {

	private static PublicacionDAOImplementation instance = null;
	private  PublicacionDAOImplementation() {};
	public static PublicacionDAOImplementation getInstance() {
		if(null == instance) {
			instance = new PublicacionDAOImplementation();
		}
		return instance;
	}
	
	
	
	@Override
	public void create(Publicacion publicacion) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(publicacion);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Publicacion read(Integer id) {
		
		Publicacion publicacion = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			publicacion = session.get(Publicacion.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return publicacion;
	}

	@Override
	public void update(Publicacion publicacion) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(publicacion);
			session.getTransaction().commit();
			} catch (Exception e) {
			} finally {
				session.close();
				
				
			}
		
	}

	@Override
	public void delete(Publicacion publicacion) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
		session.beginTransaction();
		session.delete(publicacion);
		session.getTransaction().commit();
		} catch (Exception e) {
				} finally {
					session.close();
					
					
				}
		
	}

	@Override
	public List<Publicacion> listAll(List<Publicacion> publicaciones) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
