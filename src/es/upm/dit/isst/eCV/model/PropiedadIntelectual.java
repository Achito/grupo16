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
public class PropiedadIntelectual implements Serializable{
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String tituloPropiedad;
	private String numeroSolicitud;
	private String pais;
	private String region;
	private String nombre;
	private String posicion;
	private String entidadDerechos;
	private String filtro;
	
	@ManyToOne
	private Investigador investigador;
	
	

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@Temporal(TemporalType.DATE)
	private Date fechaConcesion;

	public String getTituloPropiedad() {
		return tituloPropiedad;
	}

	public void setTituloPropiedad(String tituloPropiedad) {
		this.tituloPropiedad = tituloPropiedad;
	}

	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}

	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getEntidadDerechos() {
		return entidadDerechos;
	}

	public void setEntidadDerechos(String entidadDerechos) {
		this.entidadDerechos = entidadDerechos;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaConcesion() {
		return fechaConcesion;
	}

	public void setFechaConcesion(Date fechaConcesion) {
		this.fechaConcesion = fechaConcesion;
	}

	public Integer getId() {
		return id;
	}
	
	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}
	
	

}
