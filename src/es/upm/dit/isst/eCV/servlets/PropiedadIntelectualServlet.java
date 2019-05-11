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
import es.upm.dit.isst.eCV.dao.PropiedadIntelectualDAOImplementation;
import es.upm.dit.isst.eCV.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.model.PropiedadIntelectual;
import es.upm.dit.isst.eCV.model.Proyecto;

@WebServlet("/PropiedadIntelectualServlet")
public class PropiedadIntelectualServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

			Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

			req.setAttribute("investigador", investigador);

			req.setAttribute("proyectos", investigador.getProyectos());
			req.setAttribute("propiedades", investigador.getPropiedades());
			req.getSession().setAttribute("propiedadEdit", null);
			
			
			
			if(req.getParameter("edit") != null) {
				
					Integer propiedadEditId = Integer.parseInt(req.getParameter("edit"));
					System.out.println(propiedadEditId);
				
					PropiedadIntelectual propiedadEdit = PropiedadIntelectualDAOImplementation.getInstance().read(propiedadEditId);
				
					req.getSession().setAttribute("propiedadEdit", propiedadEdit);

			}
			

			
			getServletContext().getRequestDispatcher("/ExperienciaCientificaView.jsp").forward(req, resp);
		}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("edit"));
		System.out.println(req.getParameter("delete"));		
		
		if(req.getSession().getAttribute("propiedadEdit") != null) {
			System.out.println("editin");
			this.edit(req, resp);
		}
			else if(req.getParameter("delete") != null) {
				System.out.println("deletin");
			this.delete(req, resp);

		}else {
			
			this.create(req, resp);
		}
		
		resp.sendRedirect(req.getContextPath()+"/PropiedadIntelectualServlet");
		
	}


	private void create(HttpServletRequest req, HttpServletResponse resp) {
		
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String tituloPropiedad = req.getParameter("tituloPropiedad");
		String numeroSolicitud = req.getParameter("numeroSolicitud");
		String pais = req.getParameter("pais");
		String region = req.getParameter("region");
		String nombre = req.getParameter("nombre");
		String posicion = req.getParameter("posicion");
		String filtro = req.getParameter("filtro");
		String entidadDerechos = req.getParameter("entidadDerechos");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaRegistro = null;
		
		if( req.getParameter("fechaRegistro") != null && !req.getParameter("fechaRegistro").equals("")) {
		
		try {
			
			fechaRegistro = (Date) format.parse(req.getParameter("fechaRegistro"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Date fechaConcesion = null;
		
		if( req.getParameter("fechaConcesion") != null && !req.getParameter("fechaConcesion").equals("")) {
		
		try {
			
			fechaConcesion = (Date) format.parse(req.getParameter("fechaConcesion"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		PropiedadIntelectual propiedad = new PropiedadIntelectual();
		
		propiedad.setTituloPropiedad(tituloPropiedad);
		propiedad.setNumeroSolicitud(numeroSolicitud);
		propiedad.setPais(pais);
		propiedad.setRegion(region);
		propiedad.setNombre(nombre);
		propiedad.setPosicion(posicion);
		propiedad.setFiltro(filtro);
		propiedad.setInvestigador(investigador);
		propiedad.setEntidadDerechos(entidadDerechos);
		
		if(fechaRegistro != null) {
			propiedad.setFechaRegistro(fechaRegistro);
		}
		
		if(fechaConcesion != null) {
			propiedad.setFechaRegistro(fechaRegistro);
		}
		
		PropiedadIntelectualDAOImplementation.getInstance().create(propiedad);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
		
	}


	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		Integer id = Integer.parseInt(req.getParameter("delete"));
		PropiedadIntelectual propiedad = PropiedadIntelectualDAOImplementation.getInstance().read(id);
		PropiedadIntelectualDAOImplementation.getInstance().delete(propiedad);
		
		
	}


	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String tituloPropiedad = req.getParameter("tituloPropiedad");
		String numeroSolicitud = req.getParameter("numeroSolicitud");
		String pais = req.getParameter("pais");
		String region = req.getParameter("region");
		String nombre = req.getParameter("nomber");
		String posicion = req.getParameter("posicion");
		String filtro = req.getParameter("filtro");
		String entidadDerechos = req.getParameter("entidadDerechos");
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaRegistro = null;
		
		if( req.getParameter("fechaRegistro") != null && !req.getParameter("fechaRegistro").equals("")) {
		
		try {
			
			fechaRegistro = (Date) format.parse(req.getParameter("fechaRegistro"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Date fechaConcesion = null;
		
		if( req.getParameter("fechaConcesion") != null && !req.getParameter("fechaConcesion").equals("")) {
		
		try {
			
			fechaConcesion = (Date) format.parse(req.getParameter("fechaConcesion"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		PropiedadIntelectual propiedad = (PropiedadIntelectual) req.getSession().getAttribute("propiedadEdit");
		
		propiedad.setTituloPropiedad(tituloPropiedad);
		propiedad.setNumeroSolicitud(numeroSolicitud);
		propiedad.setPais(pais);
		propiedad.setRegion(region);
		propiedad.setNombre(nombre);
		propiedad.setPosicion(posicion);
		propiedad.setFiltro(filtro);
		propiedad.setInvestigador(investigador);
		propiedad.setEntidadDerechos(entidadDerechos);
		
		if(fechaRegistro != null) {
			propiedad.setFechaRegistro(fechaRegistro);
		}
		
		if(fechaConcesion != null) {
			propiedad.setFechaRegistro(fechaRegistro);
		}
		
		PropiedadIntelectualDAOImplementation.getInstance().update(propiedad);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
		
	}
	
	
	
	

}
