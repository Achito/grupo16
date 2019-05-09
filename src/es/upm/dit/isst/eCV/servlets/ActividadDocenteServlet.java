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

import es.upm.dit.isst.eCV.dao.ActividadDocenteDAOImplementation;
import es.upm.dit.isst.eCV.dao.DoctoradoDAOImplementation;
import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.model.ActividadDocente;
import es.upm.dit.isst.eCV.model.Doctorado;
import es.upm.dit.isst.eCV.model.Investigador;

@WebServlet("/ActividadDocenteServlet")
public class ActividadDocenteServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

		Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

		req.setAttribute("investigador", investigador);

		req.setAttribute("actividadesDocentes", investigador.getActividadesDocentes());
		
		req.getSession().setAttribute("actEdit", null);
		
		
		
		if(req.getParameter("edit") != null) {
			
				Integer actEditId = Integer.parseInt(req.getParameter("edit"));
				
			
				ActividadDocente actEdit = ActividadDocenteDAOImplementation.getInstance().read(actEditId);
			
				req.getSession().setAttribute("actEdit", actEdit);
				
			
			
		}
		

		
		getServletContext().getRequestDispatcher("/ActividadDocenteView.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("edit"));
		System.out.println(req.getParameter("delete"));		
		
		if(req.getSession().getAttribute("actEdit") != null) {
			System.out.println("editin");
			this.edit(req, resp);
		}
			else if(req.getParameter("delete") != null) {
				System.out.println("deletin");
			this.delete(req, resp);

		}else {
			
			this.create(req, resp);
		}
		
		resp.sendRedirect(req.getContextPath()+"/ActividadDocenteServlet");
		
	}


	private void create(HttpServletRequest req, HttpServletResponse resp) {
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String titulo = req.getParameter("titulo");
		String nombreAlumno = req.getParameter("nombreAlumno");
		String entidad = req.getParameter("entidad");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


		
		Date fechaDefensa = null;
		
		if( req.getParameter("fechaDefensa") != null && !req.getParameter("fechaDefensa").equals("")) {
			
			try {
				
				fechaDefensa = (Date) format.parse(req.getParameter("fechaDefensa"));
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			}
		
		ActividadDocente act = new ActividadDocente();
		act.setTitulo(titulo);
		act.setEntidad(entidad);
		act.setNombreAlumno(nombreAlumno);
		act.setInvestigador(investigador);
		
		if(fechaDefensa != null) {
			act.setFechaDefensa(fechaDefensa);
			}
		
		ActividadDocenteDAOImplementation.getInstance().create(act);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
	}


	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.parseInt(req.getParameter("delete"));
		ActividadDocente act = ActividadDocenteDAOImplementation.getInstance().read(id);
		ActividadDocenteDAOImplementation.getInstance().delete(act);
		
		
	}


	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String titulo = req.getParameter("titulo");
		String nombreAlumno = req.getParameter("nombreAlumno");
		String entidad = req.getParameter("entidad");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


		
		Date fechaDefensa = null;
		
		if( req.getParameter("fechaDefensa") != null && !req.getParameter("fechaDefensa").equals("")) {
			
			try {
				
				fechaDefensa = (Date) format.parse(req.getParameter("fechaDefensa"));
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			}
		
		ActividadDocente act = (ActividadDocente) req.getSession().getAttribute("actEdit");
		
		act.setTitulo(titulo);
		act.setEntidad(entidad);
		act.setNombreAlumno(nombreAlumno);
		act.setInvestigador(investigador);
		
		if(fechaDefensa != null) {
			act.setFechaDefensa(fechaDefensa);
			}
		
		ActividadDocenteDAOImplementation.getInstance().update(act);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
	}
	
	
	
	
	
}
