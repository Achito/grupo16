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
public class SituacionProfesional implements Serializable{
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String entidadEmpleadora;
	private String categoriaProfesional;
	private Integer modalidadContrato;
	private String primaria;
	private String secundaria;
	private String terciaria;
	private Integer dedicacion;
	private String palabrasClave;
	private String funciones;
	private Integer tipoEntidad;
	
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaFinal;
	
	@ManyToOne
	private Investigador investigador;
	


	public Integer getId() {
		return id;
	}


	public String getEntidadEmpleadora() {
		return entidadEmpleadora;
	}

	public void setEntidadEmpleadora(String entidadEmpleadora) {
		this.entidadEmpleadora = entidadEmpleadora;
	}

	public String getCategoriaProfesional() {
		return categoriaProfesional;
	}

	public void setCategoriaProfesional(String categoriaProfesional) {
		this.categoriaProfesional = categoriaProfesional;
	}

	public Integer getModalidadContrato() {
		return modalidadContrato;
	}

	public void setModalidadContrato(Integer modalidadContrato) {
		this.modalidadContrato = modalidadContrato;
	}

	public String getPrimaria() {
		return primaria;
	}

	public void setPrimaria(String primaria) {
		this.primaria = primaria;
	}

	public String getSecundaria() {
		return secundaria;
	}

	public void setSecundaria(String secundaria) {
		this.secundaria = secundaria;
	}

	public String getTerciaria() {
		return terciaria;
	}

	public void setTerciaria(String terciaria) {
		this.terciaria = terciaria;
	}

	public Integer getDedicacion() {
		return dedicacion;
	}

	public void setDedicacion(Integer dedicacion) {
		this.dedicacion = dedicacion;
	}

	public String getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	public String getFunciones() {
		return funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	public Integer getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(Integer tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	public Investigador getInvestigador() {
		return investigador;
	}


	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}
	

}
