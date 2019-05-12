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

import es.upm.dit.isst.eCV.dao.ActividadSanitariaDAOImplementation;
import es.upm.dit.isst.eCV.dao.DoctoradoDAOImplementation;
import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.model.ActividadSanitaria;
import es.upm.dit.isst.eCV.model.Doctorado;
import es.upm.dit.isst.eCV.model.Investigador;

@WebServlet("/ActividadSanitariaServlet")
public class ActividadSanitariaServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

		Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

		req.setAttribute("investigador", investigador);

		req.setAttribute("sanitarias", investigador.getSanitarias());
		
		req.getSession().setAttribute("sanitariaEdit", null);
		
		
		
		if(req.getParameter("edit") != null) {
			
				Integer sanitariaEditId = Integer.parseInt(req.getParameter("edit"));
				System.out.println(sanitariaEditId);
			
				ActividadSanitaria sanitariaEdit = ActividadSanitariaDAOImplementation.getInstance().read(sanitariaEditId);
			
				req.getSession().setAttribute("sanitariaEdit", sanitariaEdit);
				
			
			
		}
		

		
		getServletContext().getRequestDispatcher("/ActividadSanitariaView.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("edit"));
		System.out.println(req.getParameter("delete"));		
		
		if(req.getSession().getAttribute("sanitariaEdit") != null) {
			System.out.println("editin");
			this.edit(req, resp);
		}
			else if(req.getParameter("delete") != null) {
				System.out.println("deletin");
			this.delete(req, resp);

		}else {
			
			this.create(req, resp);
		}
		
		resp.sendRedirect(req.getContextPath()+"/ActividadSanitariaServlet");
		
	}


	private void create(HttpServletRequest req, HttpServletResponse resp) {
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String resultados = req.getParameter("resultados");
		String entidadRealizacion = req.getParameter("entidadRealizacion");
		String entidadAfiliacion = req.getParameter("entidadAfiliacion");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


		
		Date fechaInicio = null;
		
		if( req.getParameter("fechaInicio") != null && !req.getParameter("fechaInicio").equals("")) {
		
		try {
			
			fechaInicio = (Date) format.parse(req.getParameter("fechaInicio"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Date fechaFin = null;
		
		if( req.getParameter("fechaFin") != null && !req.getParameter("fechaFin").equals("")) {
		
		try {
			
			fechaFin = (Date) format.parse(req.getParameter("fechaFin"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		ActividadSanitaria sanitaria = new ActividadSanitaria();
		sanitaria.setResultados(resultados);
		sanitaria.setEntidadRealizacion(entidadRealizacion);
		sanitaria.setEntidadAfiliacion(entidadAfiliacion);
		sanitaria.setInvestigador(investigador);
		
		if(fechaInicio != null) {
			sanitaria.setFechaInicio(fechaInicio);
			}
		
		if(fechaFin != null) {
			sanitaria.setFechaFin(fechaFin);
			}
		
		ActividadSanitariaDAOImplementation.getInstance().create(sanitaria);
		InvestigadorDAOImplementation.getInstance().update(investigador);
	}


	private void delete(HttpServletRequest req, HttpServletResponse resp) {

		
		Integer id = Integer.parseInt(req.getParameter("delete"));
		ActividadSanitaria sanitaria = ActividadSanitariaDAOImplementation.getInstance().read(id);
		ActividadSanitariaDAOImplementation.getInstance().delete(sanitaria);
	}


	private void edit(HttpServletRequest req, HttpServletResponse resp) {
Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String resultados = req.getParameter("resultados");
		String entidadRealizacion = req.getParameter("entidadRealizacion");
		String entidadAfiliacion = req.getParameter("entidadAfiliacion");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


		
		Date fechaInicio = null;
		
		if( req.getParameter("fechaInicio") != null && !req.getParameter("fechaInicio").equals("")) {
		
		try {
			
			fechaInicio = (Date) format.parse(req.getParameter("fechaInicio"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Date fechaFin = null;
		
		if( req.getParameter("fechaFin") != null && !req.getParameter("fechaFin").equals("")) {
		
		try {
			
			fechaFin = (Date) format.parse(req.getParameter("fechaFin"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		ActividadSanitaria sanitaria = (ActividadSanitaria) req.getSession().getAttribute("sanitariaEdit");
		
		sanitaria.setResultados(resultados);
		sanitaria.setEntidadRealizacion(entidadRealizacion);
		sanitaria.setEntidadAfiliacion(entidadAfiliacion);
		sanitaria.setInvestigador(investigador);
		
		if(fechaInicio != null) {
			sanitaria.setFechaInicio(fechaInicio);
			}
		
		if(fechaFin != null) {
			sanitaria.setFechaFin(fechaFin);
			}
		
		ActividadSanitariaDAOImplementation.getInstance().update(sanitaria);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
	}
	
	

}
