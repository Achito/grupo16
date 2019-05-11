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

import es.upm.dit.isst.eCV.dao.InvestigadorDAO;
import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.dao.SituacionProfesionalDAOImplementation;
import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.model.SituacionProfesional;

@WebServlet("/SituacionProfesionalServlet")
public class SituacionProfesionalServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

		Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

		req.setAttribute("investigador", investigador);

		req.setAttribute("situacionesProfesionales", investigador.getSituacionesProfesionales());
		req.getSession().setAttribute("spEdit", null);
		
		
		
		if(req.getParameter("edit") != null) {
			
				Integer spEditId = Integer.parseInt(req.getParameter("edit"));
				System.out.println(spEditId);
			
				SituacionProfesional spEdit = SituacionProfesionalDAOImplementation.getInstance().read(spEditId);
			
				req.getSession().setAttribute("spEdit", spEdit);
				
			
			
		}
		

		
		getServletContext().getRequestDispatcher("/SituacionProfesionalView.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("edit"));
		System.out.println(req.getParameter("delete"));		
		
		if(req.getSession().getAttribute("spEdit") != null) {
			System.out.println("editin");
			this.edit(req, resp);
		}
			else if(req.getParameter("delete") != null) {
				System.out.println("deletin");
			this.delete(req, resp);

		}else {
			
			this.create(req, resp);
		}
		
		
		
		
		resp.sendRedirect(req.getContextPath()+"/SituacionProfesionalServlet");
		

		
		
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer id = Integer.parseInt(req.getParameter("delete"));
		SituacionProfesional sp =SituacionProfesionalDAOImplementation.getInstance().read(id);
		SituacionProfesionalDAOImplementation.getInstance().delete(sp);
		
		
		
		
	}
	
	public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String entidadEmpleadora = req.getParameter("entidadEmpleadora");
		String categoriaProfesional = req.getParameter("categoriaProfesional");
		String primaria = req.getParameter("primaria");
		String secundaria = req.getParameter("secundaria");
		String terciaria = req.getParameter("terciaria");
		String palabrasClave = req.getParameter("palabrasClave");
		String funciones = req.getParameter("funciones");
		String modalidadContrato = req.getParameter("modalidadContrato");
		String dedicacion = req.getParameter("dedicacion");
		String tipoEntidad = req.getParameter("tipoEntidad");
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


		
		Date fechaFinal = null;
		
		if( req.getParameter("fechaFinal") != null && !req.getParameter("fechaFinal").equals("")) {
		
		try {
			
			 fechaFinal = (Date) format.parse(req.getParameter("fechaFinal"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Date fechaInicio = null;
		
		if( req.getParameter("fechaInicio") != null && !req.getParameter("fechaInicio").equals("")) {
			
			try {
				
				 fechaInicio = (Date) format.parse(req.getParameter("fechaInicio"));
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			}
		
		System.out.println(fechaInicio);
		System.out.println(fechaFinal);
		
		SituacionProfesional sp = new SituacionProfesional();
		
		sp.setEntidadEmpleadora(entidadEmpleadora);
		sp.setCategoriaProfesional(categoriaProfesional);
		sp.setPrimaria(primaria);
		sp.setSecundaria(secundaria);
		sp.setTerciaria(terciaria);
		sp.setPalabrasClave(palabrasClave);
		sp.setFunciones(funciones);
		sp.setInvestigador(investigador);
		sp.setModalidadContrato(modalidadContrato);
		sp.setModalidadContrato(dedicacion);
		sp.setTipoEntidad(tipoEntidad);
		
		
		
		
		
		
		if(fechaInicio != null) {
			sp.setFechaInicio(fechaInicio);
			}
		
		if(fechaFinal != null) {
			sp.setFechaFinal(fechaFinal);
			}
		
		SituacionProfesionalDAOImplementation.getInstance().create(sp);
		
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
		

		
	}
	
	public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String entidadEmpleadora = req.getParameter("entidadEmpleadora");
		String categoriaProfesional = req.getParameter("categoriaProfesional");
		String primaria = req.getParameter("primaria");
		String secundaria = req.getParameter("secundaria");
		String terciaria = req.getParameter("terciaria");
		String palabrasClave = req.getParameter("palabrasClave");
		String funciones = req.getParameter("funciones");
		String modalidadContrato = req.getParameter("modalidadContrato");
		String dedicacion = req.getParameter("dedicacion");
		String tipoEntidad = req.getParameter("tipoEntidad");


		
		System.out.println(req.getParameter("fechaFinal"));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


		
		Date fechaFinal = null;
		
		if( req.getParameter("fechaFinal") != null && !req.getParameter("fechaFinal").equals("")) {
		
		try {
			
			 fechaFinal = (Date) format.parse(req.getParameter("fechaFinal"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Date fechaInicio = null;
		
		if( req.getParameter("fechaInicio") != null && !req.getParameter("fechaInicio").equals("")) {
			
			try {
				
				 fechaInicio = (Date) format.parse(req.getParameter("fechaInicio"));
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			}
		
		
		
		SituacionProfesional sId = (SituacionProfesional) req.getSession().getAttribute("spEdit");
		System.out.println(sId.getId());
		SituacionProfesional sp = SituacionProfesionalDAOImplementation.getInstance().read(sId.getId());
		
		sp.setEntidadEmpleadora(entidadEmpleadora);
		System.out.println(sp.getEntidadEmpleadora());
		sp.setCategoriaProfesional(categoriaProfesional);
		sp.setPrimaria(primaria);
		sp.setSecundaria(secundaria);
		sp.setTerciaria(terciaria);
		sp.setPalabrasClave(palabrasClave);
		sp.setFunciones(funciones);
		sp.setInvestigador(investigador);
		sp.setModalidadContrato(modalidadContrato);
		sp.setModalidadContrato(dedicacion);
		sp.setTipoEntidad(tipoEntidad);
		
		
		
		
		if(fechaInicio != null) {
			sp.setFechaInicio(fechaInicio);
			}
		
		if(fechaFinal != null) {
			sp.setFechaFinal(fechaFinal);
			}
		
		SituacionProfesionalDAOImplementation.getInstance().update(sp);
		
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
		
	}
}
