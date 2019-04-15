package es.upm.dit.isst.eCV.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;

import es.upm.dit.isst.eCV.model.Investigador;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher( "/SignUpView.jsp" ).forward( req, resp );
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter( "name" );
		String password = req.getParameter( "password" );
		String email = req.getParameter( "email" );
		
		
		
		Investigador investigador = new Investigador();
		
		password = new Sha256Hash(password).toString();
		
		
		investigador.setName(name);
		investigador.setPassword(password);
		investigador.setEmail(email);
		
		
		InvestigadorDAOImplementation.getInstance().create(investigador);
		
		resp.sendRedirect(req.getContextPath()+"/LoginServlet");
		
		
		
	}
	

}
