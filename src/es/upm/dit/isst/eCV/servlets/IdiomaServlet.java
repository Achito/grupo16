package es.upm.dit.isst.eCV.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.eCV.dao.DoctoradoDAOImplementation;
import es.upm.dit.isst.eCV.dao.IdiomaDAOImplementation;
import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.model.Doctorado;
import es.upm.dit.isst.eCV.model.Idioma;
import es.upm.dit.isst.eCV.model.Investigador;

public class IdiomaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

		Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

		req.setAttribute("investigador", investigador);

		req.setAttribute("idiomas", investigador.getIdiomas());
		req.getSession().setAttribute("idiomaEdit", null);
		
		
		
		if(req.getParameter("edit") != null) {
			
				Integer idiomaEditId = Integer.parseInt(req.getParameter("edit"));
				System.out.println(idiomaEditId);
			
				Idioma idiomaEdit = IdiomaDAOImplementation.getInstance().read(idiomaEditId);
			
				req.getSession().setAttribute("idiomaEdit", idiomaEdit);
				
			
			
		}
		

		
		getServletContext().getRequestDispatcher("/FormacionAcademicaView.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("edit"));
		System.out.println(req.getParameter("delete"));		
		
		if(req.getSession().getAttribute("idiomaEdit") != null) {
			System.out.println("editin");
			this.edit(req, resp);
		}
			else if(req.getParameter("delete") != null) {
				System.out.println("deletin");
			this.delete(req, resp);

		}else {
			
			this.create(req, resp);
		}
		
		resp.sendRedirect(req.getContextPath()+"/IdiomaServlet");
		
	}


	private void create(HttpServletRequest req, HttpServletResponse resp) {
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String idioma = req.getParameter("idioma");
		String compAuditiva = req.getParameter("compAuditiva");
		String compLectora = req.getParameter("compLectora");
		String intOral = req.getParameter("intOral");
		String expOral = req.getParameter("expOral");
		String expEscrita = req.getParameter("expEscrita");
		
		Idioma idio = new Idioma();
		
		idio.setIdioma(idioma);
		idio.setCompAuditiva(compAuditiva);
		idio.setCompLectora(compLectora);
		idio.setIntOral(intOral);
		idio.setExpOral(expOral);
		idio.setExpEscrita(expEscrita);
		
		IdiomaDAOImplementation.getInstance().create(idio);
		InvestigadorDAOImplementation.getInstance().update(investigador);
	
		
	}


	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		
		Integer id = Integer.parseInt(req.getParameter("delete"));
		Idioma idio = IdiomaDAOImplementation.getInstance().read(id);
		IdiomaDAOImplementation.getInstance().delete(idio);
		
	}


	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String idioma = req.getParameter("idioma");
		String compAuditiva = req.getParameter("compAuditiva");
		String compLectora = req.getParameter("compLectora");
		String intOral = req.getParameter("intOral");
		String expOral = req.getParameter("expOral");
		String expEscrita = req.getParameter("expEscrita");
		
		Idioma idio = (Idioma) req.getSession().getAttribute("idiomaEdit");
		
		idio.setIdioma(idioma);
		idio.setCompAuditiva(compAuditiva);
		idio.setCompLectora(compLectora);
		idio.setIntOral(intOral);
		idio.setExpOral(expOral);
		idio.setExpEscrita(expEscrita);
		
		IdiomaDAOImplementation.getInstance().update(idio);
		InvestigadorDAOImplementation.getInstance().update(investigador);

		
		
	}
	
	
	

}
