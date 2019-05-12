package es.upm.dit.isst.eCV.servlets;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.Element;

import es.upm.dit.isst.eCV.model.Investigador;
import es.upm.dit.isst.eCV.model.PropiedadIntelectual;
import es.upm.dit.isst.eCV.model.Proyecto;
import es.upm.dit.isst.eCV.model.Publicacion;
import es.upm.dit.isst.eCV.model.SituacionProfesional;
import es.upm.dit.isst.eCV.model.TituloAcademico;
import es.upm.dit.isst.eCV.model.ActividadDocente;
import es.upm.dit.isst.eCV.model.Doctorado;
import es.upm.dit.isst.eCV.model.Idioma;



@WebServlet("/DescargarCVServlet")
public class DescargarCVServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletOutputStream sout = resp.getOutputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Investigador investigador = (Investigador) req.getSession().getAttribute("investigador");
		
		
		
		
		PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		
		Document document = new Document(pdf);
		Paragraph p1 = new Paragraph("Curriculum Vitae").setFontSize(20);	
		p1.setTextAlignment(TextAlignment.CENTER);
		document.add(p1);
		
		
		byte[] foto = investigador.getPhoto();
		if(foto != null) {
		ImageData data = ImageDataFactory.create(foto);		
		Image img = new Image(data);
		img.setHeight(70);
		img.setWidth(70);
		img.setFixedPosition(500 , 750);		
		document.add(img);
		}
		
		
		Paragraph p2 = new Paragraph("Información Personal");
		p2.setBold();
		p2.setUnderline();
		document.add(p2);
		
		List list = new List();
		
		String nombre = investigador.getName();
		String dni = investigador.getDocumentNumber();
		String domicilio = investigador.getAddress1();
		String provincia = investigador.getProvincia();
		String email = investigador.getEmail();
		Integer telefono = investigador.getPhone1();
		String fechaNacimiento = investigador.getBirth().toString();
		
		
		ListItem item = new ListItem("Nombre Completo: " + nombre );
		list.add(item);		
		item = new ListItem("DNI: " + dni);
		list.add(item);		
		item = new ListItem("Domicilio: " + domicilio + " (" + provincia + ")");
		list.add(item);		
		item = new ListItem("Email: " + email);
		list.add(item);		
		item = new ListItem("Teléfono: " + telefono);
		list.add(item);		
		item = new ListItem("Fecha de Nacimiento: " + fechaNacimiento);
		list.add(item);	
		
	
		document.add(list);
		
		java.util.List<SituacionProfesional> situacion = investigador.getSituacionesProfesionales();
		
		//Si hay Situación profesional entra.
		if(!situacion.isEmpty()) {
			Paragraph sit = new Paragraph("Situación Profesional");
			sit.setBold();
			sit.setUnderline();
			document.add(sit);
			
			Table table = new Table(4);
			table.setTextAlignment(TextAlignment.CENTER);			
			table.addHeaderCell("Categoría Profesional");
			table.addHeaderCell("Entidad Empleadora");
			table.addHeaderCell("Fecha de Inicio");
			table.addHeaderCell("Fecha de Finalización");
			
			for(SituacionProfesional i  : situacion){
				table.addCell(i.getCategoriaProfesional());
				table.addCell(i.getEntidadEmpleadora());
				table.addCell(i.getFechaInicio().toString());
				Date fech = i.getFechaFinal();
				if(fech == null) {
					table.addCell("Actualidad");
				}else {
					table.addCell(fech.toString());
				}
			}
			document.add(table);
			
		}
		
		
		
		
		
		java.util.List<Idioma> idiomas = investigador.getIdiomas();		
		java.util.List<TituloAcademico> titulos = investigador.getTitulosAcademicos();
		java.util.List<Doctorado> doctorados = investigador.getDoctorados();
		
		
		//Si hay informacion Academica Entra
		if(!titulos.isEmpty() || !doctorados.isEmpty() ||!idiomas.isEmpty() ) {
			Paragraph p3 = new Paragraph("Formación Académica");
			p3.setBold();
			p3.setUnderline();
			document.add(p3);
			
			if(!titulos.isEmpty()) {
				Paragraph p4 = new Paragraph("Títulos");
				p4.setUnderline();
				document.add(p4);
				
				
				Table table = new Table(3);
				table.setTextAlignment(TextAlignment.CENTER);
				table.addHeaderCell("Nombre del Título");
				table.addHeaderCell("Entidad de Titulación");
				table.addHeaderCell("Fecha de Titulación");
				
				for(TituloAcademico i  : titulos){
					table.addCell(i.getNombreTitulo());
					table.addCell(i.getEntidadTitulacion());
					table.addCell(i.getFechaTitulacion().toString());
				}
				document.add(table);
				
			}
			
			if(!doctorados.isEmpty()) {
				Paragraph p5 = new Paragraph("Doctorados");
				p5.setUnderline();
				document.add(p5);
				
				
				Table table = new Table(3);
				table.setTextAlignment(TextAlignment.CENTER);
				table.addHeaderCell("Programa de Doctorado");
				table.addHeaderCell("Entidad de Titulación");
				table.addHeaderCell("Fecha de Titulación");
				
				for(Doctorado i  : doctorados){
					table.addCell(i.getProgramaDoctorado());
					table.addCell(i.getEntidadTitulacion());
					table.addCell(i.getFechaTitulacion().toString());
				}
				document.add(table);
				
			}
			
			
			
			if(!idiomas.isEmpty()) {
				Paragraph p6 = new Paragraph("Idiomas");
				p6.setUnderline();
				document.add(p6);
				
				
				Table table = new Table(6);
				table.setTextAlignment(TextAlignment.CENTER);
				table.addHeaderCell("Idioma");
				table.addHeaderCell("Comprension Auditiva");
				table.addHeaderCell("Comprension de Lectura");
				table.addHeaderCell("Interacción Oral");
				table.addHeaderCell("Expresión Oral");
				table.addHeaderCell("Expresión Escrita");
				
				for(Idioma i  : idiomas){
					table.addCell(i.getIdioma());
					table.addCell(i.getCompAuditiva());
					table.addCell(i.getCompLectora());
					table.addCell(i.getIntOral());
					table.addCell(i.getExpOral());
					table.addCell(i.getExpEscrita());
				}
				document.add(table);
			}
		}
		
		
		java.util.List<ActividadDocente> docente = investigador.getActividadesDocentes();
		
		//Añadaimos Actividad Docente
		if(!docente.isEmpty()) {
			Paragraph act = new Paragraph("Actividad Docente");
			act.setBold();
			act.setUnderline();
			document.add(act);
			
			Table table = new Table(3);
			table.setTextAlignment(TextAlignment.CENTER);			
			table.addHeaderCell("Título del Trabajo");
			table.addHeaderCell("Entidad de Realización");
			table.addHeaderCell("Fecha de Defensa");
			
			for(ActividadDocente i  : docente){
				table.addCell(i.getTitulo());
				table.addCell(i.getEntidad());
				table.addCell(i.getFechaDefensa().toString());
							
			}
			document.add(table);
			
		}
		
		java.util.List<Proyecto> imasd = investigador.getProyectos(); // I+D
		java.util.List<PropiedadIntelectual> intelect = investigador.getPropiedades();//Propiedad Intelectual
		
		//Añadimos Experiencia Cientifica y Docente
		
		if(!imasd.isEmpty() || !intelect.isEmpty()) {
		
			if(!imasd.isEmpty()) {
				
				Paragraph pro = new Paragraph("Proyectos de I + D");
				pro.setBold();
				pro.setUnderline();
				document.add(pro);
				
				Table table = new Table(5);
				table.setTextAlignment(TextAlignment.CENTER);			
				table.addHeaderCell("Nombre del Proyecto");
				table.addHeaderCell("Nº de Investigadores");
				table.addHeaderCell("Entidad de Realización");			
				table.addHeaderCell("Fecha de Inicio");
				table.addHeaderCell("Fecha de Finalización");
				
				for(Proyecto i  : imasd){
					table.addCell(i.getNombreProyecto());
					table.addCell(i.getNumeroInvestigadores().toString());
					table.addCell(i.getEntidadRealizacion());
					table.addCell(i.getFechaInicio().toString());
					table.addCell(i.getFechaFin().toString());
								
				}
				document.add(table);
				
			}
			
			if(!intelect.isEmpty()) {
				
				Paragraph prop = new Paragraph("Propiedad Industrial");
				prop.setBold();
				prop.setUnderline();
				document.add(prop);
				
				Table table = new Table(4);
				table.setTextAlignment(TextAlignment.CENTER);			
				table.addHeaderCell("Título de Propiedad");
				table.addHeaderCell("Entidad Titular de Derechos");			
				table.addHeaderCell("Fecha de Registro");
				table.addHeaderCell("Fecha de Concesión");
				table.addHeaderCell("Pais de Inscripción");
				
				for(PropiedadIntelectual i  : intelect){
					table.addCell(i.getTituloPropiedad());
					table.addCell(i.getEntidadDerechos());
					table.addCell(i.getFechaRegistro().toString());
					table.addCell(i.getFechaConcesion().toString());
					table.addCell(i.getPais());								
				}
				document.add(table);
				
			}
			
			
			
		}
		
		//Añadimos Actividad Cientifica y Tecnologica
		
		java.util.List<Publicacion> pub = investigador.getPublicaciones();
		
		if(!pub.isEmpty()) {
			
			Paragraph prop = new Paragraph("Propiedad Industrial");
			prop.setBold();
			prop.setUnderline();
			document.add(prop);
			
			Table table = new Table(4);
			table.setTextAlignment(TextAlignment.CENTER);			
			table.addHeaderCell("Título de Publicación");
			table.addHeaderCell("Nombre de la Publicación");			
			table.addHeaderCell("Título de Producción");
			table.addHeaderCell("Fecha de Publicación");
			table.addHeaderCell("Editorial");
			table.addHeaderCell("Tipo de Soporte");
			table.addHeaderCell("Nº de Páginas");
			
			for(Publicacion i  : pub){
				table.addCell(i.getTituloPublicacion());
				table.addCell(i.getNombrePublicacion());
				table.addCell(i.getTituloProduccion());
				table.addCell(i.getFechaPublicacion().toString());
				table.addCell(i.getEditorial());
				table.addCell(i.getTipoSoporte());
				table.addCell(i.getFin());	
			}
			document.add(table);
			
		}			


		document.close();
		pdf.close();

		resp.setContentType("application/pdf");
		resp.setContentLength(baos.size());
		baos.writeTo(sout);
	}

}