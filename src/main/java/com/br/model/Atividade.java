package com.br.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="atividade")
public class Atividade {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer iCodAti;
	
	@Column(nullable=false)
	@NotNull(message="O campo nome não pode ficar vazio.")
	private String sNomAti;
	
	@Column(nullable=false)
	@NotNull(message="O campo descrição não pode ficar vazio.")
	private String sDesAti;
	
	@Column(nullable=false)
	private Date dDatAti;
	
	@Column(nullable=false)
	private Date dTemEst;
	
	@ManyToOne
	@JoinColumn(name="atividade_curso_fk", nullable=false)
	private Curso atividadeCurso;

	public Atividade() {
		super();
	}

	public Atividade(Integer iCodAti, String sNomAti, String sDesAti, Date dDatAti, Date dTemEst,
			Curso atividadeCurso) {
		super();
		this.iCodAti = iCodAti;
		this.sNomAti = sNomAti;
		this.sDesAti = sDesAti;
		this.dDatAti = dDatAti;
		this.dTemEst = dTemEst;
		this.atividadeCurso = atividadeCurso;
	}

	public Integer getiCodAti() {
		return iCodAti;
	}

	public void setiCodAti(Integer iCodAti) {
		this.iCodAti = iCodAti;
	}

	public String getsNomAti() {
		return sNomAti;
	}

	public void setsNomAti(String sNomAti) {
		this.sNomAti = sNomAti;
	}

	public String getsDesAti() {
		return sDesAti;
	}

	public void setsDesAti(String sDesAti) {
		this.sDesAti = sDesAti;
	}

	public Date getdDatAti() {
		return dDatAti;
	}

	public void setdDatAti(Date dDatAti) {
		this.dDatAti = dDatAti;
	}

	public Date getdTemEst() {
		return dTemEst;
	}

	public void setdTemEst(Date dTemEst) {
		this.dTemEst = dTemEst;
	}

	public Curso getAtividadeCurso() {
		return atividadeCurso;
	}

	public void setAtividadeCurso(Curso atividadeCurso) {
		this.atividadeCurso = atividadeCurso;
	}

	@Override
	public String toString() {
		return "Atividade [iCodAti=" + iCodAti + ", sNomAti=" + sNomAti + ", sDesAti=" + sDesAti + ", dDatAti="
				+ dDatAti + ", dTemEst=" + dTemEst + ", atividadeCurso=" + atividadeCurso + "]";
	}

	
	


}
