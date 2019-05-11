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
public class Publicacion implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String tituloProduccion;
	private String tituloPublicacion;
	private String nombrePublicacion;
	private String tipoSoporte;
	private String editorial;
	private String volumen;
	private String numero;
	private String inicial;
	private String fin;
	private String posicion;
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	private String nombreAutor;
	private String autorCorrespondencia;
	
	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;
	
	@ManyToOne
	private Investigador investigador;

	public String getTituloProduccion() {
		return tituloProduccion;
	}

	public void setTituloProduccion(String tituloProduccion) {
		this.tituloProduccion = tituloProduccion;
	}

	public String getTituloPublicacion() {
		return tituloPublicacion;
	}

	public void setTituloPublicacion(String tituloPublicacion) {
		this.tituloPublicacion = tituloPublicacion;
	}

	public String getNombrePublicacion() {
		return nombrePublicacion;
	}

	public void setNombrePublicacion(String nombrePublicacion) {
		this.nombrePublicacion = nombrePublicacion;
	}

	public String getTipoSoporte() {
		return tipoSoporte;
	}

	public void setTipoSoporte(String tipoSoporte) {
		this.tipoSoporte = tipoSoporte;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getInicial() {
		return inicial;
	}

	public void setInicial(String inicial) {
		this.inicial = inicial;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}


	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getAutorCorrespondencia() {
		return autorCorrespondencia;
	}

	public void setAutorCorrespondencia(String autorCorrespondencia) {
		this.autorCorrespondencia = autorCorrespondencia;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
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
