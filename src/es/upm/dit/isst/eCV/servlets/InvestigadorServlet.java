package es.upm.dit.isst.eCV.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.model.Investigador;

@WebServlet("/InvestigadorServlet")
public class InvestigadorServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getSession().getAttribute("investigador") == null) {
		String email = req.getParameter("email");
		
		Investigador investigador = InvestigadorDAOImplementation.getInstance().readByEmail(email);
		Integer investigadorId = investigador.getId();
		
		
		req.getSession().setAttribute("investigador", investigador);
		req.getSession().setAttribute("investigadorId", investigadorId);
		}
		
		
		getServletContext().getRequestDispatcher("/InvestigadorView.jsp").forward(req, resp);
		
		
	}

}
