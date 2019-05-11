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
import es.upm.dit.isst.eCV.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.eCV.dao.PublicacionDAOImplementation;
import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.model.Proyecto;
import es.upm.dit.isst.eCV.model.Publicacion;

@WebServlet("/PublicacionServlet")
public class PublicacionServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

			Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

			req.setAttribute("investigador", investigador);

			req.setAttribute("publicaciones", investigador.getPublicaciones());
			req.getSession().setAttribute("publicacionEdit", null);
			
			
			
			if(req.getParameter("edit") != null) {
				
					Integer publicacionEditId = Integer.parseInt(req.getParameter("edit"));
					System.out.println(publicacionEditId);
				
					Publicacion publicacionEdit = PublicacionDAOImplementation.getInstance().read(publicacionEditId);
				
					req.getSession().setAttribute("publicacionEdit", publicacionEdit);

			}
			

			
			getServletContext().getRequestDispatcher("/ActividadCientificaView.jsp").forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("edit"));
		System.out.println(req.getParameter("delete"));		
		
		if(req.getSession().getAttribute("publicacionEdit") != null) {
			System.out.println("editin");
			this.edit(req, resp);
		}
			else if(req.getParameter("delete") != null) {
				System.out.println("deletin");
			this.delete(req, resp);

		}else {
			
			this.create(req, resp);
		}
		
		resp.sendRedirect(req.getContextPath()+"/PublicacionServlet");
		
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) {

		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String tituloProduccion = req.getParameter("tituloProduccion");
		String tituloPublicacion = req.getParameter("tituloPublicacion");
		String nombrePublicacion = req.getParameter("nombrePublicacion");
		String tipoSoporte = req.getParameter("tipoSoporte");
		String editorial = req.getParameter("editorial");
		String volumen = req.getParameter("volumen");
		String numero = req.getParameter("numero");
		String inicial = req.getParameter("inicial");
		String fin = req.getParameter("fin");
		String nombreAutor = req.getParameter("autor");
		String autorCorrespondencia = req.getParameter("autorCorrespondencia");
		String posicion = req.getParameter("posicion");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaPublicacion = null;
		
		if( req.getParameter("fechaPublicacion") != null && !req.getParameter("fechaPublicacion").equals("")) {
		
		try {
			
			fechaPublicacion = (Date) format.parse(req.getParameter("fechaPublicacion"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Publicacion publicacion = new Publicacion();
		
		publicacion.setTituloProduccion(tituloProduccion);
		publicacion.setTituloPublicacion(tituloPublicacion);
		publicacion.setNombrePublicacion(nombrePublicacion);
		publicacion.setTipoSoporte(tipoSoporte);
		publicacion.setEditorial(editorial);
		publicacion.setVolumen(volumen);
		publicacion.setNumero(numero);
		publicacion.setInicial(inicial);
		publicacion.setFin(fin);
		publicacion.setNombreAutor(nombreAutor);
		publicacion.setAutorCorrespondencia(autorCorrespondencia);
		publicacion.setInvestigador(investigador);
		publicacion.setPosicion(posicion);
		
		if(fechaPublicacion != null) {
			publicacion.setFechaPublicacion(fechaPublicacion);
		}
		
		PublicacionDAOImplementation.getInstance().create(publicacion);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		
		Integer id = Integer.parseInt(req.getParameter("delete"));
		Publicacion publicacion = PublicacionDAOImplementation.getInstance().read(id);
		PublicacionDAOImplementation.getInstance().delete(publicacion);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) {

		
Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		String tituloProduccion = req.getParameter("tituloProduccion");
		String tituloPublicacion = req.getParameter("tituloPublicacion");
		String nombrePublicacion = req.getParameter("nombrePublicacion");
		String tipoSoporte = req.getParameter("tipoSoporte");
		String editorial = req.getParameter("editorial");
		String volumen = req.getParameter("volumen");
		String numero = req.getParameter("numero");
		String inicial = req.getParameter("inicial");
		String fin = req.getParameter("fin");
		String nombreAutor = req.getParameter("autor");
		String autorCorrespondencia = req.getParameter("autorCorrespondencia");
		String posicion = req.getParameter("posicion");

		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaPublicacion = null;
		
		if( req.getParameter("fechaPublicacion") != null && !req.getParameter("fechaPublicacion").equals("")) {
		
		try {
			
			fechaPublicacion = (Date) format.parse(req.getParameter("fechaPublicacion"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		
		Publicacion publicacion = (Publicacion) req.getSession().getAttribute("publicacionEdit");
		
		publicacion.setTituloProduccion(tituloProduccion);
		publicacion.setTituloPublicacion(tituloPublicacion);
		publicacion.setNombrePublicacion(nombrePublicacion);
		publicacion.setTipoSoporte(tipoSoporte);
		publicacion.setEditorial(editorial);
		publicacion.setVolumen(volumen);
		publicacion.setNumero(numero);
		publicacion.setInicial(inicial);
		publicacion.setFin(fin);
		publicacion.setNombreAutor(nombreAutor);
		publicacion.setAutorCorrespondencia(autorCorrespondencia);
		publicacion.setInvestigador(investigador);
		publicacion.setPosicion(posicion);

		
		if(fechaPublicacion != null) {
			publicacion.setFechaPublicacion(fechaPublicacion);
		}
		
		PublicacionDAOImplementation.getInstance().update(publicacion);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		
	}
	
	
	
	

}
