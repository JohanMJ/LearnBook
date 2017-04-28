package com.br.model;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name="usuario")
public class Usuario {

	private static final long serialVersionUID = -5474666057086545328L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iCodUsu;
	
	@Column(nullable=false, length=55)
	@NotNull(message="O campo sNomUsu não pode ficar vazio")
	@NotEmpty(message="O campo sNomUsu não pode ficar vazio")
	private String sNomUsu;

	@Column(unique=true)
	@NotNull(message="O campo e-mail não pode ficar vazio")
	@Pattern(
			regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
			message="O campo e-mail deve conter um endereço válido"
			)
	private String sLogUsu;
	
	@Column
	@NotNull(message="O campo senha não pode ficar vazio")
	@NotEmpty(message="O campo senha não pode ficar vazio")
	@Size(min=6, message="O campo senha deve conter menos que 6 caracteres")
	private String sSenUsu;
	
	@DateTimeFormat
	@Column
	private Date dDatUsu;

	@OneToOne(mappedBy="usuario", fetch=FetchType.EAGER)
	@Valid
	private Endereco address;
	
	@ManyToMany
    @JoinTable(name = "user_curso_apply", joinColumns = 
    @JoinColumn(name = "iCodUsu", referencedColumnName = "iCodUsu"), inverseJoinColumns = 
    @JoinColumn(name = "iCodCur", referencedColumnName = "iCodCur"))
	private Set<Curso> cursosAprendidos;
		
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = 
    @JoinColumn(name = "iCodUsu", referencedColumnName = "iCodUsu"), inverseJoinColumns = 
    @JoinColumn(name = "role", referencedColumnName = "sNomUsu"))
	private Set<Role> roles;

	public Usuario() {
		super();
	}

	public Usuario(Integer iCodUsu, String sNomUsu, String sLogUsu, String sSenUsu, Date dDatUsu, Endereco address,
			Set<Curso> cursosAprendidos, Set<Role> roles) {
		super();
		this.iCodUsu = iCodUsu;
		this.sNomUsu = sNomUsu;
		this.sLogUsu = sLogUsu;
		this.sSenUsu = sSenUsu;
		this.dDatUsu = dDatUsu;
		this.address = address;
		this.cursosAprendidos = cursosAprendidos;
		this.roles = roles;
	}

	public Integer getiCodUsu() {
		return iCodUsu;
	}

	public void setiCodUsu(Integer iCodUsu) {
		this.iCodUsu = iCodUsu;
	}

	public String getsNomUsu() {
		return sNomUsu;
	}

	public void setsNomUsu(String sNomUsu) {
		this.sNomUsu = sNomUsu;
	}

	public String getsLogUsu() {
		return sLogUsu;
	}

	public void setsLogUsu(String sLogUsu) {
		this.sLogUsu = sLogUsu;
	}

	public String getsSenUsu() {
		return sSenUsu;
	}

	public void setsSenUsu(String sSenUsu) {
		this.sSenUsu = sSenUsu;
	}

	public Date getdDatUsu() {
		return dDatUsu;
	}

	public void setdDatUsu(Date dDatUsu) {
		this.dDatUsu = dDatUsu;
	}

	public Endereco getAddress() {
		return address;
	}

	public void setAddress(Endereco address) {
		this.address = address;
	}

	public Set<Curso> getCursosAprendidos() {
		return cursosAprendidos;
	}

	public void setCursosAprendidos(Set<Curso> cursosAprendidos) {
		this.cursosAprendidos = cursosAprendidos;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
