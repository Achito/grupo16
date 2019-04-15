package es.upm.dit.isst.eCV.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.query.Query;

import es.upm.dit.isst.eCV.dao.InvestigadorDAO;
import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.dao.SessionFactoryService;

public class InvestigadorDAOImplementation implements InvestigadorDAO{
	
	private static InvestigadorDAOImplementation instance = null;
	private InvestigadorDAOImplementation() {};
	public static InvestigadorDAOImplementation getInstance() {
		
		if(null == instance) {
			instance = new InvestigadorDAOImplementation();
		}
		
		return instance;
	}
	
	
	@Override
	public void create(Investigador investigador) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(investigador);
			session.getTransaction().commit();
			
		} catch(Exception e){
			
		}finally {
			session.close();
		}
		
	}
	
	
	
	public Investigador readByEmail(String email) {
	
		Investigador investigador = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("select i from Investigador i where i.email = :email");
			
			query.setParameter("email", email);
			investigador = (Investigador) query.uniqueResult();
			if(investigador!=null) {
				
				session.getTransaction().commit();
				
			}
			
			
			
		} finally {
			
			session.close();
		}
		

		return investigador;
	}
	
	
	@Override
	public void update(Investigador investigador) {
		
		Session  session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(investigador);
			session.getTransaction().commit();
		} catch (Exception e) {
					} finally {
						session.close();
						
						
					}
		
		
	}
	
	
	@Override
	public void delete(Investigador investigador) {
		
	Session  session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.delete(investigador);
			session.getTransaction().commit();
		} catch (Exception e) {
					} finally {
						session.close();
						
						
					}
		
	}
	
	
	@Override
	public List<Investigador> readAll() {
		
		List<Investigador> investigadores = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			investigadores.addAll(session.createQuery("from Investigador").list());
			session.getTransaction().commit();
		} catch (Exception e) {
					} finally {
						session.close();
						
						
					}
		
		
		return investigadores;
	}
	
	
	@Override
	public Investigador read(Integer id) {
		Investigador investigador = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			investigador = session.get(Investigador.class, id);
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
		}
		

		return investigador;
		
		
	}
	
	
	
	

	
	


}
