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

import es.upm.dit.isst.eCV.dao.IdiomaDAOImplementation;
import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.eCV.model.Idioma;
import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.model.Proyecto;

@WebServlet("/ProyectoServlet")
public class ProyectoServlet extends HttpServlet {

	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

		Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

		req.setAttribute("investigador", investigador);

		req.setAttribute("proyectos", investigador.getProyectos());
		req.setAttribute("propiedades", investigador.getPropiedades());
		req.getSession().setAttribute("proyectoEdit", null);
		
		
		
		if(req.getParameter("edit") != null) {
			
				Integer proyectoEditId = Integer.parseInt(req.getParameter("edit"));
				System.out.println(proyectoEditId);
			
				Proyecto proyectoEdit = ProyectoDAOImplementation.getInstance().read(proyectoEditId);
			
				req.getSession().setAttribute("proyectoEdit", proyectoEdit);

		}
		

		
		getServletContext().getRequestDispatcher("/ExperienciaCientificaView.jsp").forward(req, resp);
	}


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	System.out.println(req.getParameter("edit"));
	System.out.println(req.getParameter("delete"));		
	
	if(req.getSession().getAttribute("proyectoEdit") != null) {
		System.out.println("editin");
		this.edit(req, resp);
	}
		else if(req.getParameter("delete") != null) {
			System.out.println("deletin");
		this.delete(req, resp);

	}else {
		
		this.create(req, resp);
	}
	
	resp.sendRedirect(req.getContextPath()+"/ProyectoServlet");
	
}


private void create(HttpServletRequest req, HttpServletResponse resp) {
	
	Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
	
	String nombreProyecto = req.getParameter("nombreProyecto");
	String nombreInvestigador = req.getParameter("nombreInvestigador");
	String posicion = req.getParameter("posicion");
	String entidadRealizacion = req.getParameter("entidadRealizacion");
	String ciudad = req.getParameter("ciudad");
	String pais = req.getParameter("pais");
	String region = req.getParameter("region");
	
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
	
	Proyecto proy = new Proyecto();
	
	proy.setNombreProyecto(nombreProyecto);
	proy.setNombreInvestigador(nombreInvestigador);
	proy.setPosicion(posicion);
	proy.setEntidadRealizacion(entidadRealizacion);
	proy.setCiudad(ciudad);
	proy.setPais(pais);
	proy.setRegion(region);
	proy.setInvestigador(investigador);
	
	if(req.getParameter("numeroInvestigadores") != null && !(req.getParameter("numeroInvestigadores").equals("") )){
		Integer numeroInvestigadores =  Integer.parseInt(req.getParameter("numeroInvestigadores"));
		proy.setNumeroInvestigadores(numeroInvestigadores);
		}
	
	if(req.getParameter("cuantia") != null && !(req.getParameter("cuantia").equals("") )){
		Integer cuantia =  Integer.parseInt(req.getParameter("cuantia"));
		proy.setCuantia(cuantia);
		}
	
	if(fechaInicio != null) {
		proy.setFechaInicio(fechaInicio);
		}
	
	if(fechaFin != null) {
		proy.setFechaFin(fechaFin);
		}
	
	ProyectoDAOImplementation.getInstance().create(proy);
	InvestigadorDAOImplementation.getInstance().update(investigador);
	
	
	
}


private void delete(HttpServletRequest req, HttpServletResponse resp) {
	Integer id = Integer.parseInt(req.getParameter("delete"));
	Proyecto proy = ProyectoDAOImplementation.getInstance().read(id);
	ProyectoDAOImplementation.getInstance().delete(proy);
	
}


private void edit(HttpServletRequest req, HttpServletResponse resp) {
	
Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
	
	String nombreProyecto = req.getParameter("nombreProyecto");
	String nombreInvestigador = req.getParameter("nombreInvestigador");
	String posicion = req.getParameter("posicion");
	String entidadRealizacion = req.getParameter("entidadRealizacion");
	String ciudad = req.getParameter("ciudad");
	String pais = req.getParameter("pais");
	String region = req.getParameter("region");
	
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
	
	Proyecto proy = (Proyecto) req.getSession().getAttribute("proyectoEdit");
	
	proy.setNombreProyecto(nombreProyecto);
	proy.setNombreInvestigador(nombreInvestigador);
	proy.setPosicion(posicion);
	proy.setEntidadRealizacion(entidadRealizacion);
	proy.setCiudad(ciudad);
	proy.setPais(pais);
	proy.setRegion(region);
	proy.setInvestigador(investigador);
	
	if(req.getParameter("numeroInvestigadores") != null && !(req.getParameter("numeroInvestigadores").equals("") )){
		Integer numeroInvestigadores =  Integer.parseInt(req.getParameter("numeroInvestigadores"));
		proy.setNumeroInvestigadores(numeroInvestigadores);
		}
	
	if(req.getParameter("cuantia") != null && !(req.getParameter("cuantia").equals("") )){
		Integer cuantia =  Integer.parseInt(req.getParameter("cuantia"));
		proy.setCuantia(cuantia);
		}
	
	if(fechaInicio != null) {
		proy.setFechaInicio(fechaInicio);
		}
	
	if(fechaFin != null) {
		proy.setFechaFin(fechaFin);
		}
	
	ProyectoDAOImplementation.getInstance().update(proy);
	InvestigadorDAOImplementation.getInstance().update(investigador);
	
	
	
	
	
}




}
