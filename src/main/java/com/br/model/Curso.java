package com.br.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="curso")
public class Curso {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer iCodCur;
	
	@Column(nullable=false, length=70)
	@NotNull(message="O campo valor não pode ficar vazio")
	@NotEmpty(message="O campo valor não pode ficar vazio")
	private float fValCur;
	
	@Column(nullable=false, length=70)
	private float fAvaCur;
	
	@Column(nullable=false, length=70)
	@NotNull(message="O campo nome não pode ficar vazio")
	@NotEmpty(message="O campo nome não pode ficar vazio")
	private String sNomCur;
	
	@Column(nullable=false)
	@NotNull(message="O campo descrição não pode ficar vazio")
	@NotEmpty(message="O campo descrição não pode ficar vazio")
	private String sDesCur;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	private Date dDatCur;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	private Date dTemEst;
	
	@Column
	private String photo;
	
	@Column(nullable=false)
	private boolean bStaCur;
	
	@ManyToMany(mappedBy="cursosAprendidos")
	private Set<Usuario> cursadoPor;
	
	@OneToMany(mappedBy="atividadeCurso")
	private List<Atividade> atividades;

	public Curso() {
		super();
	}

	public Curso(Integer iCodCur, float fValCur, float fAvaCur, String sNomCur, String sDesCur, Date dDatCur,
			Date dTemEst, String photo, boolean bStaCur, Set<Usuario> cursadoPor, List<Atividade> atividades) {
		super();
		this.iCodCur = iCodCur;
		this.fValCur = fValCur;
		this.fAvaCur = fAvaCur;
		this.sNomCur = sNomCur;
		this.sDesCur = sDesCur;
		this.dDatCur = dDatCur;
		this.dTemEst = dTemEst;
		this.photo = photo;
		this.bStaCur = bStaCur;
		this.cursadoPor = cursadoPor;
		this.atividades = atividades;
	}

	public Integer getiCodCur() {
		return iCodCur;
	}

	public void setiCodCur(Integer iCodCur) {
		this.iCodCur = iCodCur;
	}

	public float getfValCur() {
		return fValCur;
	}

	public void setfValCur(float fValCur) {
		this.fValCur = fValCur;
	}

	public float getfAvaCur() {
		return fAvaCur;
	}

	public void setfAvaCur(float fAvaCur) {
		this.fAvaCur = fAvaCur;
	}

	public String getsNomCur() {
		return sNomCur;
	}

	public void setsNomCur(String sNomCur) {
		this.sNomCur = sNomCur;
	}

	public String getsDesCur() {
		return sDesCur;
	}

	public void setsDesCur(String sDesCur) {
		this.sDesCur = sDesCur;
	}

	public Date getdDatCur() {
		return dDatCur;
	}

	public void setdDatCur(Date dDatCur) {
		this.dDatCur = dDatCur;
	}

	public Date getdTemEst() {
		return dTemEst;
	}

	public void setdTemEst(Date dTemEst) {
		this.dTemEst = dTemEst;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isbStaCur() {
		return bStaCur;
	}

	public void setbStaCur(boolean bStaCur) {
		this.bStaCur = bStaCur;
	}

	public Set<Usuario> getCursadoPor() {
		return cursadoPor;
	}

	public void setCursadoPor(Set<Usuario> cursadoPor) {
		this.cursadoPor = cursadoPor;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	@Override
	public String toString() {
		return "Curso [iCodCur=" + iCodCur + ", fValCur=" + fValCur + ", fAvaCur=" + fAvaCur + ", sNomCur=" + sNomCur
				+ ", sDesCur=" + sDesCur + ", dDatCur=" + dDatCur + ", dTemEst=" + dTemEst + ", photo=" + photo
				+ ", bStaCur=" + bStaCur + ", cursadoPor=" + cursadoPor + ", atividades=" + atividades + "]";
	}
	
	


	
	
	
	
	
}
