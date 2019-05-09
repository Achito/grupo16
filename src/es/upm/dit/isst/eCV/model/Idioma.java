package es.upm.dit.isst.eCV.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Idioma implements Serializable{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String idioma;
	private String compAuditiva;
	private String compLectora;
	private String intOral;
	private String expOral;
	private String expEscrita;
	
	@ManyToOne
	private Investigador investigador;

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getCompAuditiva() {
		return compAuditiva;
	}

	public void setCompAuditiva(String compAuditiva) {
		this.compAuditiva = compAuditiva;
	}

	public String getCompLectora() {
		return compLectora;
	}

	public void setCompLectora(String compLectora) {
		this.compLectora = compLectora;
	}

	public String getIntOral() {
		return intOral;
	}

	public void setIntOral(String intOral) {
		this.intOral = intOral;
	}

	public String getExpOral() {
		return expOral;
	}

	public void setExpOral(String expOral) {
		this.expOral = expOral;
	}

	public String getExpEscrita() {
		return expEscrita;
	}

	public void setExpEscrita(String expEscrita) {
		this.expEscrita = expEscrita;
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
