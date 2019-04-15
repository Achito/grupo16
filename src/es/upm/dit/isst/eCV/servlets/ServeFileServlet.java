package es.upm.dit.isst.eCV.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.model.Investigador;


@WebServlet("/ServeFileServlet")
public class ServeFileServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");
		Investigador investigador= InvestigadorDAOImplementation.getInstance().read(investigadorId);
		
		
		resp.setContentLength(investigador.getPhoto().length);
		resp.getOutputStream().write(investigador.getPhoto());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("eliminar");
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");
		Investigador investigador= InvestigadorDAOImplementation.getInstance().read(investigadorId);
		investigador.setPhoto(null);
		InvestigadorDAOImplementation.getInstance().update(investigador);
		req.getSession().setAttribute("investigador", investigador);

		
		resp.sendRedirect(req.getContextPath() + "/InvestigadorDatosServlet" );

		

	}

}
