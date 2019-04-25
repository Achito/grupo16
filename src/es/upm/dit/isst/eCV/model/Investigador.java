package es.upm.dit.isst.eCV.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
public class Investigador implements Serializable{
	

	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String email;
	private String password;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String provincia;
	private Integer zip;
	private String document;
	private String documentNumber;
	private Integer phone1;
	private Integer phone2;
	private Integer sex;
	
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	
	@OneToMany(mappedBy = "investigador", fetch = FetchType.EAGER)
	private List<SituacionProfesional> situacionesProfesionales;
	
	@OneToMany(mappedBy = "investigador", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<TituloAcademico> titulosAcademicos;
	
	@OneToMany(mappedBy = "investigador", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Doctorado> doctorados;
	
	
	@Lob
	private byte[] photo;
	
	
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public Integer getPhone1() {
		return phone1;
	}
	public void setPhone1(Integer phone1) {
		this.phone1 = phone1;
	}
	public Integer getPhone2() {
		return phone2;
	}
	public void setPhone2(Integer phone2) {
		this.phone2 = phone2;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Integer getId() {
		return id;
	}
	
	public List<SituacionProfesional> getSituacionesProfesionales() {
		return situacionesProfesionales;
	}
	public void setSituacionesProfesionales(List<SituacionProfesional> situacionesProfesionales) {
		this.situacionesProfesionales = situacionesProfesionales;
	}
	
	public List<TituloAcademico> getTitulosAcademicos() {
		return titulosAcademicos;
	}
	public void setTitulosAcademicos(List<TituloAcademico> titulosAcademicos) {
		this.titulosAcademicos = titulosAcademicos;
	}
	
}
