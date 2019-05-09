package es.upm.dit.isst.eCV.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.eCV.model.Idioma;

public class IdiomaDAOImplementation implements IdiomaDAO {

	private static IdiomaDAOImplementation instance = null;
	private  IdiomaDAOImplementation() {};
	public static IdiomaDAOImplementation getInstance() {
		if(null == instance) {
			instance = new IdiomaDAOImplementation();
		}
		return instance;
	}
	
	
	
	@Override
	public void create(Idioma idioma) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(idioma);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Idioma read(Integer id) {
		
		Idioma idioma = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			idioma = session.get(Idioma.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return idioma;
	}

	@Override
	public void update(Idioma idioma) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(idioma);
			session.getTransaction().commit();
			} catch (Exception e) {
			} finally {
				session.close();
				
				
			}
		
	}

	@Override
	public void delete(Idioma idioma) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
		session.beginTransaction();
		session.delete(idioma);
		session.getTransaction().commit();
		} catch (Exception e) {
				} finally {
					session.close();
					
					
				}
		
	}

	@Override
	public List<Idioma> listAll(List<Idioma> idiomas) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
