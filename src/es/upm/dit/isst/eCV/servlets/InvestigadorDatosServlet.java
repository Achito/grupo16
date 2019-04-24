package es.upm.dit.isst.eCV.servlets;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.eCV.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.eCV.model.Investigador;


@WebServlet("/InvestigadorDatosServlet")

public class InvestigadorDatosServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/InvestigadorDatosView.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer investigadorId = (Integer) req.getSession().getAttribute("investigadorId");
		
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String address1 = req.getParameter("address1");
		String address2 = req.getParameter("address2");
		String city = req.getParameter("city");
		String provincia = req.getParameter("provincia");
		System.out.println(req.getParameter("photo"));
		
		String document = req.getParameter("Document");
		String documentNumber = req.getParameter("documentNumber");
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date birth = null;
		try {
			 birth = (Date) format.parse(req.getParameter("birth"));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		Investigador investigador = InvestigadorDAOImplementation.getInstance().read(investigadorId);
		
		if(birth != null) {
		investigador.setBirth(birth);
		}
		investigador.setEmail(email);
		investigador.setName(name);
		investigador.setAddress1(address1);
		investigador.setAddress2(address2);
		investigador.setCity(city);
		investigador.setProvincia(provincia);
		
		if(!(req.getParameter("zip") == "")){
			Integer zip =  Integer.parseInt(req.getParameter("zip"));
			investigador.setZip(zip);
			}
		
		investigador.setDocument(document);
		investigador.setDocumentNumber(documentNumber);
		
		if(!(req.getParameter("phone1") == "")){
			Integer phone1 = Integer.parseInt(req.getParameter("phone1"));
			investigador.setPhone1(phone1);
			};
		
		if(!(req.getParameter("phone2") == "")){
			Integer phone2 = Integer.parseInt(req.getParameter("phone2"));
			investigador.setPhone2(phone2);
			};
		
		if(!(req.getParameter("sex") == "")){
			Integer sex = Integer.parseInt(req.getParameter("sex"));
			investigador.setSex(sex);
			};
			
			if(req.getParameter("password1") != null && !req.getParameter("password1").equals("") && req.getParameter("password2") != null && 
		req.getParameter("password1").equals(req.getParameter("password2"))) {
				
				String password = new Sha256Hash(req.getParameter("password1")).toString();

				investigador.setPassword(password);
			}

		
		
		
		InvestigadorDAOImplementation.getInstance().update(investigador);
		
		req.getSession().setAttribute("investigador", investigador);
		
		resp.sendRedirect(req.getContextPath() + "/InvestigadorDatosServlet" );

		
		
		
	}

}
