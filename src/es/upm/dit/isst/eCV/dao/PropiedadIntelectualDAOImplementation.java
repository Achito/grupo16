package es.upm.dit.isst.eCV.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.model.PropiedadIntelectual;

public class PropiedadIntelectualDAOImplementation implements PropiedadIntelectualDAO{

	
	private static PropiedadIntelectualDAOImplementation instance = null;
	private PropiedadIntelectualDAOImplementation() {};
	public static PropiedadIntelectualDAOImplementation getInstance() {
		
		if(null == instance) {
			instance = new PropiedadIntelectualDAOImplementation();
		}
		
		return instance;
	}
	
	
	@Override
	public void create(PropiedadIntelectual propiedadIntelectual) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(propiedadIntelectual);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
		
	}

	
	@Override
	public PropiedadIntelectual read(Integer id) {
		
		PropiedadIntelectual propiedadIntelectual = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			propiedadIntelectual = session.get(PropiedadIntelectual.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return propiedadIntelectual;
	}
	

	@Override
	public void update(PropiedadIntelectual propiedadIntelectual) {
		
			Session  session = SessionFactoryService.get().openSession();
		
				try {
			session.beginTransaction();
			session.saveOrUpdate(propiedadIntelectual);
			session.getTransaction().commit();
					} catch (Exception e) {
					} finally {
						session.close();
						
						
					}
		
	}

	@Override
	public void delete(PropiedadIntelectual propiedadIntelectual) {
		
		Session  session = SessionFactoryService.get().openSession();
		
			try {
			session.beginTransaction();
			session.delete(propiedadIntelectual);
			session.getTransaction().commit();
			} catch (Exception e) {
					} finally {
						session.close();
						
						
					}
		
	}

	@Override
	public List<PropiedadIntelectual> listAll(List<PropiedadIntelectual> propiedadesIntelectuales) {
		// TODO Auto-generated method stub
		return null;
	}

}
