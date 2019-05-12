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
public class ActividadSanitaria implements Serializable{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String resultados;
	private String entidadRealizacion;
	private String entidadAfiliacion;
	
	@ManyToOne
	private Investigador investigador;
	
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public String getEntidadRealizacion() {
		return entidadRealizacion;
	}

	public void setEntidadRealizacion(String entidadRealizacion) {
		this.entidadRealizacion = entidadRealizacion;
	}

	public String getEntidadAfiliacion() {
		return entidadAfiliacion;
	}

	public void setEntidadAfiliacion(String entidadAfiliacion) {
		this.entidadAfiliacion = entidadAfiliacion;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getId() {
		return id;
	}
	
	
	
	
	
	

}
