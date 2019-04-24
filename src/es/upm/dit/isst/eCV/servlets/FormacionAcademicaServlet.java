package es.upm.dit.isst.eCV.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.dao.SituacionProfesionalDAOImplementation;
import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.model.SituacionProfesional;

@WebServlet("/FormacionAcademicaServlet")
public class FormacionAcademicaServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");

		Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);

		req.setAttribute("investigador", investigador);

		//req.setAttribute("formacionesAcademicas", investigador.getFormacionesAcademicas());
		req.getSession().setAttribute("faEdit", null);
		
		
		
		if(req.getParameter("edit") != null) {
			
				Integer faEditId = Integer.parseInt(req.getParameter("edit"));
				System.out.println(faEditId);
			
			//	FormacionAcademica faEdit = SituacionProfesionalDAOImplementation.getInstance().read(spEditId);
			
				//req.getSession().setAttribute("faEdit", faEdit);
				
			
			
		}
		

		
		getServletContext().getRequestDispatcher("/FormacionAcademicaView.jsp").forward(req, resp);
	}

}
