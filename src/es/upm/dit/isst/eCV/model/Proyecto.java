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
public class Proyecto implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String nombreProyecto;
	private String nombreInvestigador;
	private Integer numeroInvestigadores;
	private String posicion;
	private String entidadRealizacion;
	private String ciudad;
	private String pais;
	private String region;
	private Integer cuantia;
	
	
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	@ManyToOne
	private Investigador investigador;

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getNombreInvestigador() {
		return nombreInvestigador;
	}

	public void setNombreInvestigador(String nombreInvestigador) {
		this.nombreInvestigador = nombreInvestigador;
	}

	public Integer getNumeroInvestigadores() {
		return numeroInvestigadores;
	}

	public void setNumeroInvestigadores(Integer numeroInvestigadores) {
		this.numeroInvestigadores = numeroInvestigadores;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getEntidadRealizacion() {
		return entidadRealizacion;
	}

	public void setEntidadRealizacion(String entidadRealizacion) {
		this.entidadRealizacion = entidadRealizacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getCuantia() {
		return cuantia;
	}

	public void setCuantia(Integer cuantia) {
		this.cuantia = cuantia;
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
