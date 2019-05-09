package es.upm.dit.isst.eCV.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ActividadDocente implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String titulo;
	private String nombreAlumno;
	private String entidad;
	
	@ManyToOne
	private Investigador investigador;
	
	@Temporal(TemporalType.DATE)
	private Date fechaDefensa;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public Date getFechaDefensa() {
		return fechaDefensa;
	}

	public void setFechaDefensa(Date fechaDefensa) {
		this.fechaDefensa = fechaDefensa;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public Integer getId() {
		return id;
	}

	
	
	

}
