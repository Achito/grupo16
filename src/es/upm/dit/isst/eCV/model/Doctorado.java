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
public class Doctorado implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String programaDoctorado;
	private String entidadTitulacion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaTitulacion;
	
	@ManyToOne
	private Investigador investigador;
	
	
	public String getProgramaDoctorado() {
		return programaDoctorado;
	}

	public void setProgramaDoctorado(String programaDoctorado) {
		this.programaDoctorado = programaDoctorado;
	}

	public String getEntidadTitulacion() {
		return entidadTitulacion;
	}

	public void setEntidadTitulacion(String entidadTitulacion) {
		this.entidadTitulacion = entidadTitulacion;
	}

	public Date getFechaTitulacion() {
		return fechaTitulacion;
	}

	public void setFechaTitulacion(Date fechaTitulacion) {
		this.fechaTitulacion = fechaTitulacion;
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
