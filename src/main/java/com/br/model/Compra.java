package com.br.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="compra")
public class Compra {
	private static final long serialVersionUID = -5474666057086545328L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iCodCom;
	
	@Column(nullable=false, length=55)
	@NotNull(message="O campo valor não pode ficar vazio")
	@NotEmpty(message="O campo valor não pode ficar vazio")
	private float fValCom;
	
	@DateTimeFormat
	@Column
	private Date dDatCom;

	@ManyToMany
    @JoinTable(name = "user_recipe_cook", joinColumns = 
    @JoinColumn(name = "iCodUsu", referencedColumnName = "iCodUsu"), inverseJoinColumns = 
    @JoinColumn(name = "idRecipe", referencedColumnName = "idRecipe"))
	private Set<Curso> cursosAprendidos;


	public Compra(Integer iCodCom, float fValCom, Date dDatCom, Set<Curso> cursosAprendidos) {
		super();
		this.iCodCom = iCodCom;
		this.fValCom = fValCom;
		this.dDatCom = dDatCom;
		this.cursosAprendidos = cursosAprendidos;
	}


	public Integer getiCodCom() {
		return iCodCom;
	}


	public void setiCodCom(Integer iCodCom) {
		this.iCodCom = iCodCom;
	}


	public float getfValCom() {
		return fValCom;
	}


	public void setfValCom(float fValCom) {
		this.fValCom = fValCom;
	}


	public Date getdDatCom() {
		return dDatCom;
	}


	public void setdDatCom(Date dDatCom) {
		this.dDatCom = dDatCom;
	}


	public Set<Curso> getCursosAprendidos() {
		return cursosAprendidos;
	}


	public void setCursosAprendidos(Set<Curso> cursosAprendidos) {
		this.cursosAprendidos = cursosAprendidos;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	 
	
		
	
	
}
