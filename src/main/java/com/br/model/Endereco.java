package com.br.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer iCodEnd;
	
	@Column
	@NotNull(message="O campo cidade é obrigatório")
	@NotEmpty(message="O campo cidade é obrigatório")
	private String sCidEnd;
	
	@Column
	@NotNull(message="O campo estado é obrigatório")
	@NotEmpty(message="O campo estado é obrigatório")
	private String sEstEnd;
	
	@Column
	@NotNull(message="O campo país é obrigatório")
	@NotEmpty(message="O campo país é obrigatório")
	private String sPaiEnd;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="endereco_usuario_fk")
	private Usuario usuario;

	public Endereco() {
		super();
	}

	public Endereco(Integer iCodEnd, String sCidEnd, String sEstEnd, String sPaiEnd, Usuario usuario) {
		super();
		this.iCodEnd = iCodEnd;
		this.sCidEnd = sCidEnd;
		this.sEstEnd = sEstEnd;
		this.sPaiEnd = sPaiEnd;
		this.usuario = usuario;
	}

	public Integer getiCodEnd() {
		return iCodEnd;
	}

	public void setiCodEnd(Integer iCodEnd) {
		this.iCodEnd = iCodEnd;
	}

	public String getsCidEnd() {
		return sCidEnd;
	}

	public void setsCidEnd(String sCidEnd) {
		this.sCidEnd = sCidEnd;
	}

	public String getsEstEnd() {
		return sEstEnd;
	}

	public void setsEstEnd(String sEstEnd) {
		this.sEstEnd = sEstEnd;
	}

	public String getsPaiEnd() {
		return sPaiEnd;
	}

	public void setsPaiEnd(String sPaiEnd) {
		this.sPaiEnd = sPaiEnd;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Endereco [iCodEnd=" + iCodEnd + ", sCidEnd=" + sCidEnd + ", sEstEnd=" + sEstEnd + ", sPaiEnd=" + sPaiEnd
				+ ", usuario=" + usuario + "]";
	}
	
	
    

}
