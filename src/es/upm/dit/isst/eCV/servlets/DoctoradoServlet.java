package es.upm.dit.isst.eCV.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.eCV.dao.DoctoradoDAOImplementation;
import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.model.Doctorado;
import es.upm.dit.isst.eCV.model.Investigador;




@WebServlet("/DoctoradoServlet")
public class DoctoradoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

		Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

		req.setAttribute("investigador", investigador);

		req.setAttribute("doctorados", investigador.getDoctorados());
		req.getSession().setAttribute("docEdit", null);
		
		
		
		if(req.getParameter("edit") != null) {
			
				Integer docEditId = Integer.parseInt(req.getParameter("edit"));
				System.out.println(docEditId);
			
				Doctorado docEdit = DoctoradoDAOImplementation.getInstance().read(docEditId);
			
				req.getSession().setAttribute("docEdit", docEdit);
				
			
			
		}
		

		
		getServletContext().getRequestDispatcher("/FormacionAcademicaView.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("edit"));
		System.out.println(req.getParameter("delete"));		
		
		if(req.getSession().getAttribute("docEdit") != null) {
			System.out.println("editin");
			this.edit(req, resp);
		}
			else if(req.getParameter("delete") != null) {
				System.out.println("deletin");
			this.delete(req, resp);

		}else {
			
			this.create(req, resp);
		}
		
		resp.sendRedirect(req.getContextPath()+"/DoctoradoServlet");
		
	}


	private void create(HttpServletRequest req, HttpServletResponse resp) {
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String programaDoctorado = req.getParameter("programaDoctorado");
		String entidadTitulacion = req.getParameter("entidadTitulacion");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


		
		Date fechaTitulacion = null;
		
		if( req.getParameter("fechaTitulacion") != null && !req.getParameter("fechaTitulacion").equals("")) {
		
		try {
			
			fechaTitulacion = (Date) format.parse(req.getParameter("fechaTitulacion"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Doctorado doc = new Doctorado();
		doc.setProgramaDoctorado(programaDoctorado);
		doc.setEntidadTitulacion(entidadTitulacion);
		
		doc.setInvestigador(investigador);
		
		if(fechaTitulacion != null) {
		doc.setFechaTitulacion(fechaTitulacion);
		}
		
		DoctoradoDAOImplementation.getInstance().create(doc);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
	}


	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.parseInt(req.getParameter("delete"));
		Doctorado doc = DoctoradoDAOImplementation.getInstance().read(id);
		DoctoradoDAOImplementation.getInstance().delete(doc);
		
	}


	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String programaDoctorado = req.getParameter("programaDoctorado");
		String entidadTitulacion = req.getParameter("entidadTitulacion");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


		
		Date fechaTitulacion = null;
		
		if( req.getParameter("fechaTitulacion") != null && !req.getParameter("fechaTitulacion").equals("")) {
		
		try {
			
			fechaTitulacion = (Date) format.parse(req.getParameter("fechaTitulacion"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Doctorado doc = (Doctorado) req.getSession().getAttribute("docEdit");
		
		doc.setProgramaDoctorado(programaDoctorado);
		doc.setEntidadTitulacion(entidadTitulacion);
		doc.setInvestigador(investigador);
		
		if(fechaTitulacion != null) {
		doc.setFechaTitulacion(fechaTitulacion);
		}
		
		DoctoradoDAOImplementation.getInstance().update(doc);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
	}
	
	
	
}
