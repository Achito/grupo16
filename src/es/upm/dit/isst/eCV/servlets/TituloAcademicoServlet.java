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

import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.dao.SituacionProfesionalDAOImplementation;
import es.upm.dit.isst.eCV.dao.TituloAcademicoDAOImplementation;
import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.model.SituacionProfesional;
import es.upm.dit.isst.eCV.model.TituloAcademico;

@WebServlet("/TituloAcademicoServlet")
public class TituloAcademicoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

		Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

		req.setAttribute("investigador", investigador);

		req.setAttribute("titulosAcademicos", investigador.getTitulosAcademicos());
		req.getSession().setAttribute("taEdit", null);
		
		
		
		if(req.getParameter("edit") != null) {
			
				Integer taEditId = Integer.parseInt(req.getParameter("edit"));
				System.out.println(taEditId);
			
				TituloAcademico taEdit = TituloAcademicoDAOImplementation.getInstance().read(taEditId);
			
				req.getSession().setAttribute("taEdit", taEdit);
				
			
			
		}
		

		
		getServletContext().getRequestDispatcher("/FormacionAcademicaView.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("edit"));
		System.out.println(req.getParameter("delete"));		
		
		if(req.getSession().getAttribute("taEdit") != null) {
			System.out.println("editin");
			this.edit(req, resp);
		}
			else if(req.getParameter("delete") != null) {
				System.out.println("deletin");
			this.delete(req, resp);

		}else {
			
			this.create(req, resp);
		}
		
		resp.sendRedirect(req.getContextPath()+"/TituloAcademicoServlet");
		
	}
	
	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String nombreTitulo = req.getParameter("nombreTitulo");
		String tipoTitulo = req.getParameter("tipoTitulo");
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
		
		TituloAcademico taEdit = (TituloAcademico) req.getSession().getAttribute("taEdit");
		TituloAcademico ta = TituloAcademicoDAOImplementation.getInstance().read(taEdit.getId());
		ta.setNombreTitulo(nombreTitulo);
		ta.setTipoTitulo(tipoTitulo);
		ta.setEntidadTitulacion(entidadTitulacion);
		ta.setInvestigador(investigador);
		
		if(fechaTitulacion != null) {
		ta.setFechaTitulacion(fechaTitulacion);
		}
		
		TituloAcademicoDAOImplementation.getInstance().update(ta);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
	}

	public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String nombreTitulo = req.getParameter("nombreTitulo");
		String tipoTitulo = req.getParameter("tipoTitulo");
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
		
		TituloAcademico ta = new TituloAcademico();
		ta.setNombreTitulo(nombreTitulo);
		ta.setTipoTitulo(tipoTitulo);
		ta.setEntidadTitulacion(entidadTitulacion);
		ta.setInvestigador(investigador);
		
		if(fechaTitulacion != null) {
		ta.setFechaTitulacion(fechaTitulacion);
		}
		
		TituloAcademicoDAOImplementation.getInstance().create(ta);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
		

		
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer id = Integer.parseInt(req.getParameter("delete"));
		TituloAcademico ta = TituloAcademicoDAOImplementation.getInstance().read(id);
		TituloAcademicoDAOImplementation.getInstance().delete(ta);
		
		
		
		
	}
	
	

}
