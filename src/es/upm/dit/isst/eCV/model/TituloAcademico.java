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
public class TituloAcademico implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String nombreTitulo;
	private String tipoTitulo;
	private String entidadTitulacion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaTitulacion;
	
	@ManyToOne
	private Investigador investigador;

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public String getNombreTitulo() {
		return nombreTitulo;
	}

	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}

	public String getTipoTitulo() {
		return tipoTitulo;
	}

	public void setTipoTitulo(String tipoTitulo) {
		this.tipoTitulo = tipoTitulo;
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

	public Integer getId() {
		return id;
	}
	
	
	

}
