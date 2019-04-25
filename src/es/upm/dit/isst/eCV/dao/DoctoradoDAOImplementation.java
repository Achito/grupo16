package es.upm.dit.isst.eCV.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.eCV.model.Doctorado;

public class DoctoradoDAOImplementation implements DoctoradoDAO {

	private static DoctoradoDAOImplementation instance = null;
	private  DoctoradoDAOImplementation() {};
	public static DoctoradoDAOImplementation getInstance() {
		if(null == instance) {
			instance = new DoctoradoDAOImplementation();
		}
		return instance;
	}
	
	
	
	@Override
	public void create(Doctorado doctorado) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(doctorado);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Doctorado read(Integer id) {
		
		Doctorado doctorado = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			doctorado = session.get(Doctorado.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return doctorado;
	}

	@Override
	public void update(Doctorado doctorado) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(doctorado);
			session.getTransaction().commit();
			} catch (Exception e) {
			} finally {
				session.close();
				
				
			}
		
	}

	@Override
	public void delete(Doctorado doctorado) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
		session.beginTransaction();
		session.delete(doctorado);
		session.getTransaction().commit();
		} catch (Exception e) {
				} finally {
					session.close();
					
					
				}
		
	}

	@Override
	public List<Doctorado> listAll(List<Doctorado> doctorados) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
