package es.upm.dit.isst.eCV.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Doctorado implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String programdaDoctorado;
	private String entidadTitulacion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaTitulacion;
	
	@ManyToOne
	private Investigador investigador;
	
	
	
	
}
